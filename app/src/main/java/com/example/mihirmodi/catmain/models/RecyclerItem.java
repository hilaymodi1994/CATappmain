package com.example.mihirmodi.catmain.models;

/**
 * Created by mmodi on 2/23/2016.
 */

/**
 * Created by HBB20 on 7/14/15.
 * Recycler view provides flexibility to show items of multiple types....
 * this class will give flexibility to attach type of particular item so that it provide ease for providing layout.
 * later on along with itemType, many other property can be included.
 */
public class RecyclerItem {
    private ItemType itemType;
    private Object item;

    public  RecyclerItem (ItemType itemType, Object item) {
        this.itemType = itemType;
        this.item = item;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public enum ItemType { QUESTION_HEADER, QUESTION_OPTION}
}


