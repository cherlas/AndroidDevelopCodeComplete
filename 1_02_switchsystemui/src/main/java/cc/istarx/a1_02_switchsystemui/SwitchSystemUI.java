package cc.istarx.a1_02_switchsystemui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class SwitchSystemUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_system_ui);

        findViewById(R.id.toggleMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentVis = v.getSystemUiVisibility();
                int newVis;
                if ((currentVis & View.SYSTEM_UI_FLAG_LOW_PROFILE) == View.SYSTEM_UI_FLAG_LOW_PROFILE) {
                    newVis = View.SYSTEM_UI_FLAG_VISIBLE;
                } else {
                    newVis = View.SYSTEM_UI_FLAG_LOW_PROFILE;
                }
                v.setSystemUiVisibility(newVis);
            }
        });
    }
}
