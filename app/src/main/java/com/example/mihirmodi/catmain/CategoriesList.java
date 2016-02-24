package com.example.mihirmodi.catmain;
import com.example.mihirmodi.catmain.models.Categories;

import java.util.List;
import java.util.Vector;

public class CategoriesList {
    private List<Categories> categories;
    private boolean readcategories;
    CategoriesList() {
        categories = new Vector<Categories>(0);
    }

    void addItem(Categories cat) {
        categories.add(cat);
    }

    Categories getItem(int id ) {
        return categories.get((id));
    }

    List<Categories> getList() {
        return categories;
    }

    void setreadFromFile(boolean value)
    {
        readcategories=value;
    }

    boolean getreadFromFile()
    {
        return readcategories;
    }
}
