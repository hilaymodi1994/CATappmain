package com.example.mihirmodi.catmain.models;

/**
 * Created by hbb20 on 25/2/16.
 */
public class IWRecyclerItem {
    public static enum TYPE{QUESTION_HEADER,QUESTION_OPTION}
    TYPE itemType;
    Object item;

    public IWRecyclerItem(TYPE itemType, Object item) {
        this.itemType = itemType;
        this.item = item;
    }

    public TYPE getItemType() {
        return itemType;
    }

    public void setItemType(TYPE itemType) {
        this.itemType = itemType;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}
