package cn.davidsu.horizontaldragmoreview;

import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import cn.davidsu.library.DefaultDragMoreView;
import cn.davidsu.library.HorizontalDragMoreView;
import cn.davidsu.library.ICallBack;


public class MainActivity extends AppCompatActivity {

    private HorizontalDragMoreView horizontalDragMoreView;
    private RecyclerView rvImage;


    private @DrawableRes
    int[] testData = new int[]{
            R.drawable.icon_item_1,
            R.drawable.icon_item_2,
            R.drawable.icon_item_3,
            R.drawable.icon_item_4,
            R.drawable.icon_item_5,
    };

    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horizontalDragMoreView = findViewById(R.id.view_drag_view);
        rvImage = findViewById(R.id.rv_gallery_small_image);

        initDragMoreLayout();

        initImageList();


    }

    private void initDragMoreLayout() {
        horizontalDragMoreView.setLoadMoreView(new DefaultDragMoreView()).setLoadMoreCallBack(new ICallBack() {
            @Override
            public void loadMore() {

                //TODO:在这里实现你的逻辑，如加载更多，或者跳转到其他页面等等操作
                //模拟耗时操作
                horizontalDragMoreView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //回弹
                        horizontalDragMoreView.scrollBackToOrigin();

                        Toast.makeText(MainActivity.this, "加载成功", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);

            }
        });
    }


    private void initImageList() {
        rvImage.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvImage.addItemDecoration(new BaseSpaceItemDecoration(0, 0, 8, 0));
        adapter = new ImageAdapter();
        rvImage.setAdapter(adapter);
        rvImage.setHasFixedSize(true);
    }


    class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {

        @Override
        public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_image_item, parent, false);
            return new ImageViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ImageViewHolder holder, int position) {
            holder.bindData(testData[position]);
        }

        @Override
        public int getItemCount() {
            return testData.length;
        }
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImage;

        public ImageViewHolder(View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_item);
        }

        public void bindData(@DrawableRes int imageRes) {
            ivImage.setImageResource(imageRes);
        }
    }
}
