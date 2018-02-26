package cc.istarx.animatorview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        findViewById(R.id.complex_animator).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.complex_animator) {
            startActivity(new Intent(MainActivity.this, FlipperActivity.class));
        }
        if (viewToAnimator.getAlpha() > 0f) {
            viewToAnimator.animate().alpha(0f).translationX(1000f);
        } else {
            viewToAnimator.animate().alpha(1f);
            viewToAnimator.setTranslationX(0f);
        }
    }
}
