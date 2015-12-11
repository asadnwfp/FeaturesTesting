package com.evampsaanga.evamptesting.viewpagers;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.evampsaanga.evamptesting.R;

/**
 * Created by root on 12/8/2015.
 * https://github.com/codepath/android_guides/wiki/ViewPager-with-FragmentPagerAdapter
 */
public class ViewPagerMain extends FragmentActivity {
    ViewPager viewPager;
    FragmentPagerAdapter ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpaggermain);

        viewPager = (ViewPager) findViewById(R.id.vp_main);
        ft = new MyPagerFragment(getSupportFragmentManager()) ;

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager.setAdapter(ft);
        tabLayout.setupWithViewPager(viewPager);
    }
}
