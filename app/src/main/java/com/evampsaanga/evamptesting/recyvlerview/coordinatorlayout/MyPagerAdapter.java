package com.evampsaanga.evamptesting.recyvlerview.coordinatorlayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by root on 12/17/2015.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    final static int FRAGMENT_COUNT = 2;
    private String[] tabTitles = {"page 1","Page 2"};

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = RecyclerFragment.createInstance(0,20);
                break;
            case 1:
                fragment =  RecyclerFragment.createInstance(2,5);
                break;
            default:
                return null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
