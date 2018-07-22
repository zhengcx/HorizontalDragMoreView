package cn.davidsu.horizontaldragmoreview;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by davidsu on 2018/7/22.
 */

public class BaseSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int mTopSpace;
    private int mBottomSpace;
    private int mLeftSpace;
    private int mRightSpace;

    public BaseSpaceItemDecoration(int topSpace, int leftSpace, int rightSpace, int bottomSpace) {
        this.mTopSpace = topSpace;
        this.mLeftSpace = leftSpace;
        this.mRightSpace = rightSpace;
        this.mBottomSpace = bottomSpace;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.top = mTopSpace;
        outRect.left = mLeftSpace;
        outRect.right = mRightSpace;
        outRect.bottom = mBottomSpace;

    }
}
