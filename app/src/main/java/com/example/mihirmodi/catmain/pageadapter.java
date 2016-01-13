package com.example.mihirmodi.catmain;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by mihir modi on 1/7/2016.
 */
public class pageadapter extends FragmentPagerAdapter{
    public pageadapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0) {
        switch(arg0) {
            case 0:
                return new fragment1();
            case 1:
                return new fragment2();
            case 2:
                return new fragment3();
            case 3:
                return new fragment4();

            default:
                break;
        }
        return null;

    }

    @Override
    public int getCount() {
        return 4;
    }


}
