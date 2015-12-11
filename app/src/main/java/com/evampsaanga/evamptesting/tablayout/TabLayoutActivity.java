package com.evampsaanga.evamptesting.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.evampsaanga.evamptesting.R;
import com.evampsaanga.evamptesting.viewpagers.FirstFragment;
import com.evampsaanga.evamptesting.viewpagers.SecondFragment;

/**
 * Created by root on 12/8/2015.
 * http://stackoverflow.com/questions/33646586/tablayout-without-using-viewpager
 */
public class TabLayoutActivity
        extends FragmentActivity
        implements TabLayout.OnTabSelectedListener {
    private  FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        tabLayout = (TabLayout) findViewById(R.id.tl_activity_tablayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_launcher).setText("Send"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_launcher));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_launcher));
        tabLayout.addTab(tabLayout.newTab().setText("Send"));
        tabLayout.addTab(tabLayout.newTab().setText("Send & Post"));

        fragmentManager = getSupportFragmentManager();
        // Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_tablayout);
        fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.fragment_tablayout,new FirstFragment()).commit();



        tabLayout.setOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        switch (tab.getPosition()){
            case 0:
                Toast.makeText(this, "Tab " + tab.getPosition(), Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "Tab " + tabLayout.getSelectedTabPosition(), Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "Tab " + tabLayout.getSelectedTabPosition(), Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Tab " + tabLayout.getSelectedTabPosition(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
