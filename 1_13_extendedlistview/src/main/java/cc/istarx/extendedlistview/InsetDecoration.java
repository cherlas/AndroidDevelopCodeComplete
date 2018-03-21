package cc.istarx.extendedlistview;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by cherlas on 2018/3/21.
 */

public class InsetDecoration extends RecyclerView.ItemDecoration {
    private int mInsetMargin;

    public InsetDecoration(Context context) {
        mInsetMargin = context.getResources().getDimensionPixelOffset(R.dimen.inset_margin);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(mInsetMargin, mInsetMargin, mInsetMargin, mInsetMargin);
    }
}
