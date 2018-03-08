package cc.istarx.customanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Intent intent = new Intent(MainActivity.this,OtherActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.activity_open_enter,R.anim.activity_open_exit);
        finish();
        overridePendingTransition(R.anim.activity_close_enter,R.anim.activity_close_exit);
        */
    }
}
