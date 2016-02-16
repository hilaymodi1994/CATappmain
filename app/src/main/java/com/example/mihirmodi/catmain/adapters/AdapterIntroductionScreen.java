package com.example.mihirmodi.catmain.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mihirmodi.catmain.activities.IntroductionScreenFragment1;
import com.example.mihirmodi.catmain.activities.IntroductionScreenFragment2;
import com.example.mihirmodi.catmain.activities.IntroductionScreenFragment3;
import com.example.mihirmodi.catmain.activities.IntroductionScreenFragment4;

/**
 * Created by mihir modi on 1/7/2016.
 */
public class AdapterIntroductionScreen extends FragmentPagerAdapter{
    public AdapterIntroductionScreen(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0) {
        switch(arg0) {
            case 0:
                return new IntroductionScreenFragment1();
            case 1:
                return new IntroductionScreenFragment2();
            case 2:
                return new IntroductionScreenFragment3();
            case 3:
                return new IntroductionScreenFragment4();

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
