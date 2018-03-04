package cc.istarx.listviewhead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = new ListView(this);

        SimpleSectionAdapter<String> adapter = new SimpleSectionAdapter<String>(listView, R.layout.list_header, android.R.layout.simple_list_item_1) {
            @Override
            public void onSectionItemClick() {
                Toast.makeText(MainActivity.this,"baibai item is clicked", Toast.LENGTH_SHORT).show();
            }
        };

        adapter.addSection("Fruits",new String[]{"apple", "banana","orange","pair"});
        adapter.addSection("Vegetables",new String[] {"tomato","cabbage","potato"});
        adapter.addSection("People",new String[]{"baibai","me"});

        listView.setAdapter(adapter);

        setContentView(listView);
    }
}
