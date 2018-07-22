package cn.davidsu.library;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by davidesu on 2018/5/10.
 */

public class DefaultDragMoreView implements ILoadMore {

    private TextView tvText;

    @Override
    public void startDrag(View view) {
        tvText.setText("左拉加载");
    }

    @Override
    public void onDraging(float dragPercent, View view) {

    }

    @Override
    public void onLoading(View view) {
        tvText.setText("loading...");
    }

    @Override
    public View getView(@NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_horizontal_default_more, parent, false);
        tvText = view.findViewById(R.id.tv_drag_text);
        return view;
    }
}
