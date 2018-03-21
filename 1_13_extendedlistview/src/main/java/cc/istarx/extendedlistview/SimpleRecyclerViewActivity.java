package cc.istarx.extendedlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class SimpleRecyclerViewActivity extends AppCompatActivity implements SimpleItemAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private SimpleItemAdapter mAdapter;

    private LinearLayoutManager mHorizontalManager;
    private LinearLayoutManager mVerticalManager;
    private GridLayoutManager mHorizontalGridLayout;
    private GridLayoutManager mVerticalGridLayout;

    private ConnectorDecoration mConnectors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRecyclerView = new RecyclerView(this);
        mHorizontalManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mVerticalManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mHorizontalGridLayout = new GridLayoutManager(this, 8, GridLayoutManager.HORIZONTAL, false);
        mVerticalGridLayout = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);

        mConnectors = new ConnectorDecoration(this);
        mVerticalGridLayout.setSpanSizeLookup(new GridStaggerLookUp());

        mAdapter = new SimpleItemAdapter(this);
        mAdapter.setmOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addItemDecoration(new InsetDecoration(this));
        selectLayoutManager(R.id.action_vertical);
        setContentView(mRecyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return selectLayoutManager(item.getItemId());
    }

    private boolean selectLayoutManager(int id) {
        switch (id) {
            case R.id.action_vertical:
                mRecyclerView.setLayoutManager(mVerticalManager);
                mRecyclerView.removeItemDecoration(mConnectors);
                return true;
            case R.id.action_horizontal:
                mRecyclerView.setLayoutManager(mHorizontalManager);
                mRecyclerView.removeItemDecoration(mConnectors);
                return true;
            case R.id.action_grid_vertical:
                mRecyclerView.setLayoutManager(mVerticalGridLayout);
                mRecyclerView.addItemDecoration(mConnectors);
                return true;
            case R.id.action_grid_horizontal:
                mRecyclerView.setLayoutManager(mHorizontalGridLayout);
                mRecyclerView.removeItemDecoration(mConnectors);
                return true;
            case R.id.action_add_item:
                mAdapter.insertItemAtIndex("Inserted", 1);
                return true;
            case R.id.action_delete_item:
                mAdapter.removeItemAtIndex(1);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onItemClick(SimpleItemAdapter.ItemHolder item, int position) {
        Toast.makeText(this, item.getSummary(), Toast.LENGTH_SHORT).show();
    }
}
