package cc.istarx.customlistviewline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ListView listView = new ListView(this);
        String[] items = new String[]{"A","B","C","D"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.custom_row, R.id.line1, items);
        listView.setAdapter(adapter);

        setContentView(listView);
    }
}
