package cc.istarx.extendedlistview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cherlas on 2018/3/21.
 */

public class SimpleItemAdapter extends RecyclerView.Adapter<SimpleItemAdapter.ItemHolder> {

    private static final String[] ITEMS = {
            "Apple", "Orange", "Bananas", "Mangos", "Carrots", "Peas", "Broccoli", "Pork", "Chicken", "Beef", "Lamb"};
    private List<String> mItems;
    private OnItemClickListener mOnItemClickListener;
    private LayoutInflater mLayoutInflater;

    public SimpleItemAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mItems = new ArrayList<>();
        mItems.addAll(Arrays.asList(ITEMS));
        mItems.addAll(Arrays.asList(ITEMS));
    }

    public OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    public void setmOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public void insertItemAtIndex(String item, int position) {
        mItems.add(position, item);
        notifyItemInserted(position);
    }

    public void removeItemAtIndex(int position) {
        if (position >= mItems.size()) return;
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public SimpleItemAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.collection_item, parent, false);
        return new ItemHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(SimpleItemAdapter.ItemHolder holder, int position) {
        holder.setTitle("Item #" + (position + 1));
        holder.setSummary(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public interface OnItemClickListener {
        public void onItemClick(ItemHolder item, int position);
    }

    public static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private SimpleItemAdapter mParent;
        private TextView mTitleView, mSummaryView;

        public ItemHolder(View itemView, SimpleItemAdapter parent) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.mParent = parent;

            mTitleView = itemView.findViewById(R.id.text_title);
            mSummaryView = itemView.findViewById(R.id.summary);
        }

        public void setTitle(CharSequence title) {
            mTitleView.setText(title);
        }

        public CharSequence getSummary() {
            return mSummaryView.getText();
        }

        public void setSummary(CharSequence summary) {
            mSummaryView.setText(summary);
        }

        @Override
        public void onClick(View v) {
            final OnItemClickListener listener = mParent.getOnItemClickListener();
            if (listener != null) {
                listener.onItemClick(this, getAdapterPosition());
            }
        }
    }
}
