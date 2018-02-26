package cc.istarx.animatorview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View viewToAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.toggleButton);
        button.setOnClickListener(this);

        viewToAnimator = findViewById(R.id.the_view);
    }

    @Override
    public void onClick(View v) {
        if (viewToAnimator.getAlpha() > 0f) {
            viewToAnimator.animate().alpha(0f).translationX(1000f);
        } else {
            viewToAnimator.animate().alpha(1f);
            viewToAnimator.setTranslationX(0f);
        }
    }
}
