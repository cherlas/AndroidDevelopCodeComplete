package cc.istarx.createandshowview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class CreateAndShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_create_and_show);

        LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_create_and_show, null);
        Button reset = new Button(this);
        reset.setText("Reset Form");
        linearLayout.addView(reset, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        setContentView(linearLayout);

        findViewById(R.id.custom_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateAndShowActivity.this, CustomViewActivity.class));
            }
        });
    }
}
