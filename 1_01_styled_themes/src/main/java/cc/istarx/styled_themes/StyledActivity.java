package cc.istarx.styled_themes;

import android.app.Activity;
import android.os.Bundle;

public class StyledActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_styled);
    }
}
