package cc.istarx.listviewhead;

/**
 * Created by cherlas on 2018/2/28.
 */

public class SectionItem<T> {
    private String mTitle;

    public SectionItem(String mTitle, T[] items) {
        if (mTitle == null) mTitle = "";
        this.mTitle = mTitle;
        this.items = items;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public T getItem(int position) {
        return items[position];
    }

    public void setItems(T[] items) {
        this.items = items;
    }

    private T[] items;

    public int getCount(){
        return items == null ? 1 : 1 + items.length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj!=null && obj instanceof SectionItem) {
            return ((SectionItem) obj).getmTitle().equals(mTitle);
        }
        return false;
    }
}
