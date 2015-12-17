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
import com.evampsaanga.evamptesting.recyvlerview.coordinatorlayout.CoordinatorMainActivity;
import com.evampsaanga.evamptesting.recyvlerview.help_codepath.RecyclerViewMainActivity;
import com.evampsaanga.evamptesting.tablayout.TabLayoutActivity;
import com.evampsaanga.evamptesting.toolbars.ReusingToolBar;
import com.evampsaanga.evamptesting.toolbars.ScrollingToolBar;
import com.evampsaanga.evamptesting.toolbars.ToolBarMainActivity;
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
        listNames = new String[9];
        listNames[0]="ListActivity";
        listNames[1]="View Pagers";
        listNames[2]="Tab Layout";
        listNames[3]="Toolbar View";
        listNames[4]="Reusing ToolBar";
        listNames[5]="Scrolling ToolBar";
        listNames[6]="Recycler View";
        listNames[7]="Recycler View Main";
        listNames[8]="Coordinator Main";
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
                i = new Intent(this, ToolBarMainActivity.class);
                startActivity(i);
                break;
            case 4:
                i = new Intent(this, ReusingToolBar.class);
                startActivity(i);
                break;
            case 5:
                i = new Intent(this, ScrollingToolBar.class);
                startActivity(i);
                break;
            case 6:
                i = new Intent(this, RecyclerViewMainActivity.class);
                startActivity(i);
                break;
            case 7:
                i = new Intent(this, com.evampsaanga.evamptesting.recyvlerview.RecyclerViewMainActivity.class);
                startActivity(i);
                break;
            case 8:
                i = new Intent(this, CoordinatorMainActivity.class);
                startActivity(i);
                break;
            default:
                Toast.makeText(this,"pos: "+ position,Toast.LENGTH_SHORT).show();
        }
    }
}
