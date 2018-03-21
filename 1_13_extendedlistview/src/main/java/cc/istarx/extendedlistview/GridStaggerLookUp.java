package cc.istarx.extendedlistview;

import android.support.v7.widget.GridLayoutManager;

/**
 * Created by cherlas on 2018/3/21.
 */

class GridStaggerLookUp extends GridLayoutManager.SpanSizeLookup {
    @Override
    public int getSpanSize(int position) {
        return (position % 3 == 0 ? 2 : 1);
    }
}
