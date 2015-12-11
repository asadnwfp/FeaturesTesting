package com.evampsaanga.evamptesting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.evampsaanga.evamptesting.listviews.ListViewMainActivity;
import com.evampsaanga.evamptesting.listviews.expandablelistview.ExpandableListActivity;
import com.evampsaanga.evamptesting.tablayout.TabLayoutActivity;
import com.evampsaanga.evamptesting.viewpagers.ViewPagerMain;

/**
 * Created by root on 12/8/2015.
 */
public class MainActivity
        extends Activity
        implements AdapterView.OnItemClickListener{
    private String [] listNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create List Names
        createListNames();
        ListView lv_main = (ListView) findViewById(R.id.lv_main_activity);
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.listview_main_activity, R.id.tv_listview_main_activity, listNames);
        lv_main.setAdapter(adapter);
        lv_main.setOnItemClickListener(this);
    }

    private void createListNames(){
        listNames = new String[4];
        listNames[0]="ListActivity";
        listNames[1]="View Pagers";
        listNames[2]="Tab Layout";
        listNames[3]="Expandable List View";
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i ;
        switch (position){
            case 0:
                i = new Intent(this, ListViewMainActivity.class);
                startActivity(i);
                break;
            case 1:
                i = new Intent(this, ViewPagerMain.class);
                startActivity(i);
                break;
            case 2:
                i = new Intent(this, TabLayoutActivity.class);
                startActivity(i);
                break;
            case 3:
                i = new Intent(this, ExpandableListActivity.class);
                startActivity(i);
                break;
            default:
                Toast.makeText(this,"pos: "+ position,Toast.LENGTH_SHORT).show();
        }
    }
}
