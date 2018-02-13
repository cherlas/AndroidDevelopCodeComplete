package cc.istarx.a1_02_switchsystemui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

public class SwitchSystemUI extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_switch_system_ui);

        findViewById(R.id.toggle_system_ui).setOnClickListener(this);
        findViewById(R.id.hide_navigation).setOnClickListener(this);
        findViewById(R.id.switch_fullscreen).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toggle_system_ui:
                switchSystemUI(v);
                break;
            case R.id.hide_navigation:
                hideNavigation(v);
                break;
            case R.id.switch_fullscreen:
                showFullscreen(v);
                break;
            default:
                break;
        }
    }

    private void showFullscreen(View view) {
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN /*隐藏状态栏以及 Action Bar */
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION /* 隐藏导航栏*/
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE/* 不要移动布局*/);
    }

    private void hideNavigation(View view) {
        // 只需要隐藏，隐藏之后点击屏幕任何位置都会显示出来导航栏
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    private void switchSystemUI(View view) {
        int currentVis = view.getSystemUiVisibility();
        int newVis;
        if ((currentVis & View.SYSTEM_UI_FLAG_LOW_PROFILE) == View.SYSTEM_UI_FLAG_LOW_PROFILE) {
            newVis = View.SYSTEM_UI_FLAG_VISIBLE;
        } else {
            newVis = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        }
        view.setSystemUiVisibility(newVis);
    }
}
