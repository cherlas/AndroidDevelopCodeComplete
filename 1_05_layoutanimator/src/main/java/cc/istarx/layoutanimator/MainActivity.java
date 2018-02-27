package cc.istarx.layoutanimator;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContainer = findViewById(R.id.verticalContainer);

        LayoutTransition transition = new LayoutTransition();
        mContainer.setLayoutTransition(transition);

        // 反转进入
        Animator appearAnim = ObjectAnimator.ofFloat(null, "rotationY", 90f, 0f)
                .setDuration(transition.getDuration(LayoutTransition.APPEARING));
        transition.setAnimator(LayoutTransition.APPEARING, appearAnim);

        // 反转消失
        Animator disAppearAnim = ObjectAnimator.ofFloat(null, "rotationY", 0f, 90f)
                .setDuration(transition.getDuration(LayoutTransition.DISAPPEARING));
        transition.setAnimator(LayoutTransition.DISAPPEARING, disAppearAnim);

        // 通过滑动动画代替默认布局改变时的动画，需要立即设置一些动画，
        // 需要创建多个PropertyValueHolder对象的动画，这个动画回让视图进入并短暂的缩小一半长度
        PropertyValuesHolder pvhSlide = PropertyValuesHolder.ofFloat("y", 0, 1);
        PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofFloat("scaleY",1f,0.5f,1f);
        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofFloat("scaleX",1f,0.5f,1f);

        Animator changingAppearingAnim = ObjectAnimator.ofPropertyValuesHolder(this,pvhSlide,pvhScaleX,pvhScaleY)
                .setDuration(transition.getDuration(LayoutTransition.CHANGE_DISAPPEARING));
        transition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,changingAppearingAnim);
    }

    public void onAddClick(View v) {
        final Button button = new Button(this);
        button.setText(R.string.click_to_remove);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContainer.removeView(button);
            }
        });

        mContainer.addView(button, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
    }
}
