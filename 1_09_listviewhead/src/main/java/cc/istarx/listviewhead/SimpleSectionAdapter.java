package cc.istarx.listviewhead;

import android.animation.PropertyValuesHolder;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cherlas on 2018/2/28.
 */

public abstract class SimpleSectionAdapter<T> extends BaseAdapter implements AdapterView.OnItemClickListener{

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private LayoutInflater inflater;
    private int mHeaderResource;
    private int mItemResource;

    // 所有节的唯一集合
    List<SectionItem<T>> mSctions;
    // 节的分组，初始位置
    private SparseArray<SectionItem<T>> mKeyedSections;

    public SimpleSectionAdapter(ListView parent,int headerResId, int itemResId) {
        inflater = LayoutInflater.from(parent.getContext());
        this.mHeaderResource = headerResId;
        this.mItemResource = itemResId;

        mSctions = new ArrayList<>();
        mKeyedSections  = new SparseArray<>();

        parent.setOnItemClickListener(this);
    }

    public void  addSection(String title, T[] items) {
        SectionItem<T> sectionItem = new SectionItem<>(title,items);
        //添加节，替换具有相同标题的现有节
        int currentIndex = mSctions.indexOf(sectionItem);
        if (currentIndex >= 0) {
            mSctions.remove(sectionItem);
            mSctions.add(currentIndex,sectionItem);
        } else {
            mSctions.add(sectionItem);
        }

        reorderSections();
        notifyDataSetChanged();
    }

    private void reorderSections() {
        mKeyedSections.clear();
        int startPosition = 0;
        for (SectionItem<T> item : mSctions) {
            mKeyedSections.put(startPosition,item);
            startPosition += item.getCount();
        }
    }

    @Override
    public int getCount() {
        int count =0;
        for (SectionItem<T> item :mSctions) {
            count += item.getCount();
        }
        return count;
    }

    @Override
    public T getItem(int position) {
        return findSectionItemAtPosition(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderAtPosition(position)) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    private T findSectionItemAtPosition(int position) {
        int firstIndex, lastIndex;
        for (int i = 0; i< mKeyedSections.size() ; i++) {
            firstIndex = mKeyedSections.keyAt(i);
            lastIndex = firstIndex + mKeyedSections.valueAt(i).getCount();
            if (lastIndex >= firstIndex && position <lastIndex) {
                int sectionPosition = position - firstIndex -1;
                return mKeyedSections.valueAt(i).getItem(sectionPosition);
            }
        }
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return !isHeaderAtPosition(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                return getHeaderView(position,convertView,parent);
            case TYPE_ITEM:
                return getItemView(position,convertView,parent);
            default:
                return convertView;
        }
    }

    private View getHeaderView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(mHeaderResource,parent,false);
        }

        SectionItem<T> item = mKeyedSections.get(position);
        TextView textView = (TextView) convertView.findViewById(R.id.header_text);
        textView.setText(item.getmTitle());
        return convertView;
    }

    private View getItemView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(mItemResource,parent,false);
        }
        T item = findSectionItemAtPosition(position);
        TextView textView = convertView.findViewById(android.R.id.text1);
        if (item != null) {
            textView.setText(item.toString());
        } else {
            textView.setText("");
        }
        return convertView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        T item = findSectionItemAtPosition(position);
        if (item != null) {
            onSectionItemClick();
        }
    }

    abstract public void onSectionItemClick();

    public boolean isHeaderAtPosition(int position) {
        for (int i = 0; i < mKeyedSections.size(); i++) {
            if (position == mKeyedSections.keyAt(i)) {
                return true;
            }
        }
        return false;
    }
}
