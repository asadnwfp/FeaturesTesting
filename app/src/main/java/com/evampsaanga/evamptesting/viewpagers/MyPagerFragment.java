package com.evampsaanga.evamptesting.viewpagers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by root on 12/8/2015.
 */
public class MyPagerFragment extends FragmentPagerAdapter{
    private static int NUM_ITEMS = 3;
    private String[] tabTitles = {"page 1","Page 2","Page 3"};
    public MyPagerFragment(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = FirstFragment.newInstance(0, "page 1");
                break;
            case 1:
                fragment = SecondFragment.newInstance(1, "page 2");
                break;
            case 2:
                fragment = FirstFragment.newInstance(3, "page 1");
                break;
            default:

                return null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
