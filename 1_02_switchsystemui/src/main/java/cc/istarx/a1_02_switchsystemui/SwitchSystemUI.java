package cc.istarx.a1_02_switchsystemui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SwitchSystemUI extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_system_ui);

        findViewById(R.id.toggle_system_ui).setOnClickListener(this);
        findViewById(R.id.hide_navigation).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toggle_system_ui:
                switchSystemUI(v);
                break;
            case R.id.hide_navigation:
                hideNavigation(v);
        }
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
