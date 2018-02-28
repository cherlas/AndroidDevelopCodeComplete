package cc.istarx.customlistviewline;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ListView listView = new ListView(this);
        String[] items = new String[]{"A", "B", "C", "D"};
        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_row, R.id.line1, items);
        listView.setAdapter(adapter);

        setContentView(listView);
    }

    private static class CustomAdapter extends ArrayAdapter<String> {

        public CustomAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull String[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            if (row == null) {
                row = LayoutInflater.from(getContext()).inflate(R.layout.custom_row, parent, false);
            }

            String item = getItem(position);
            ImageView left = row.findViewById(R.id.leftImage);
            ImageView right = row.findViewById(R.id.rightImage);
            TextView text = row.findViewById(R.id.line1);
            left.setImageResource(R.drawable.ic_launcher_background);
            right.setImageResource(R.drawable.ic_launcher_foreground);
            text.setText(item);
            return row;
        }
    }
}
