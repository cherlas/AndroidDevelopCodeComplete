package cc.istarx.combinationview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cherlas on 2018/3/5.
 */

public class TextImageButton extends FrameLayout {

    private ImageView imageView;
    private TextView textView;
    public TextImageButton(@NonNull Context context) {
        this(context,null);
    }

    public TextImageButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TextImageButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, android.R.attr.buttonStyle);

        imageView = new ImageView(context,attrs,defStyleAttr);
        textView = new TextView(context,attrs,defStyleAttr);

        FrameLayout.LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT, Gravity.CENTER);

        this.addView(imageView,params);
        this.addView(textView,params);

        if (imageView.getDrawable() != null) {
            textView.setVisibility(GONE);
            imageView.setVisibility(VISIBLE);
        } else {
            textView.setVisibility(VISIBLE);
            imageView.setVisibility(GONE);
        }
    }

    public void setText(String text){
        textView.setVisibility(VISIBLE);
        imageView.setVisibility(GONE);
        textView.setText(text);
    }

    public void setImageResource(int resId) {
        imageView.setVisibility(VISIBLE);
        textView.setVisibility(GONE);
        imageView.setImageResource(resId);
    }

    public void setImageDrawable(Drawable drawable) {
        imageView.setVisibility(VISIBLE);
        textView.setVisibility(GONE);
        imageView.setImageDrawable(drawable);
    }
}
