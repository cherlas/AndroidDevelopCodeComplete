package cc.istarx.viewtransform;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

/**
 * Created by cherlas on 2018/3/16.
 */

public class PerspectiveLayout extends LinearLayout {
    public PerspectiveLayout(Context context) {
        super(context);
        init();
    }

    public PerspectiveLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PerspectiveLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setStaticTransformationsEnabled(true);
    }

    @Override
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        t.clear();
        if (getOrientation() == HORIZONTAL) {
            float delta = 1.0f - child.getLeft() / getWidth();
            t.getMatrix().setScale(delta, delta, getHeight() / 2, getWidth() / 2);
        } else {
            float delta = 1.0f - child.getTop() / getHeight();
            t.getMatrix().setScale(delta, delta, getWidth() / 2, getHeight() / 2);
            t.setAlpha(delta);
        }
        return true;
    }
}
