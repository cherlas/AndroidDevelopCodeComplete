package cc.istarx.animatorview;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by cherlas on 2018/2/26.
 */

public class FlipperActivity extends AppCompatActivity {

    private boolean mIsHead;
    // private ObjectAnimator mFlipper;
    private AnimatorSet mFlipper;
    private Bitmap mHeadImage;
    private Bitmap mTailsImage;
    private ImageView mFlipImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flipper);

        mHeadImage = BitmapFactory.decodeResource(getResources(), R.drawable.heads);
        mTailsImage = BitmapFactory.decodeResource(getResources(), R.drawable.tails);

        mFlipImage = findViewById(R.id.flip_image);
        mFlipImage.setImageBitmap(mHeadImage);
        mIsHead = true;

//        mFlipper = ObjectAnimator.ofFloat(mFlipImage, "rotationY", 0f, 360f);
//        mFlipper.setDuration(500);
        mFlipper = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.flip);
        mFlipper.setTarget(mFlipImage);
        ObjectAnimator animator = (ObjectAnimator) mFlipper.getChildAnimations().get(0);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (animation.getAnimatedFraction() > 0.25f && mIsHead) {
                    mFlipImage.setImageBitmap(mTailsImage);
                    mIsHead = false;
                }
                if (animation.getAnimatedFraction() > 0.75 && !mIsHead) {
                    mFlipImage.setImageBitmap(mHeadImage);
                    mIsHead =true;
                }
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mFlipper.start();
            return true;
        }
        return super.onTouchEvent(event);
    }
}
