package com.evampsaanga.evamptesting.listviews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.evampsaanga.evamptesting.R;
import com.evampsaanga.evamptesting.listviews.customlistview.CustomListActivity;
import com.evampsaanga.evamptesting.listviews.expandablelistview.ExpandableListActivity;
import com.evampsaanga.evamptesting.listviews.spiceexpandablelistview.SpiceExpandableListView;
import com.evampsaanga.evamptesting.listviews.youtubelistivew.YouTubeMainActivity;

/**
 * Created by root on 12/9/2015.
 */
public class ListViewMainActivity
        extends AppCompatActivity
        implements AdapterView.OnItemClickListener{
    private String [] listValuess = {
            "Custom List Activity",
            "Expandable List Activity",
            "Spice Expandable List View",
            "Youtube","Value 5"};
    private ArrayAdapter <String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_main);
        // Implementing Search to edit text
        // http://stackoverflow.com/questions/14663725/list-view-filter-android
        EditText searchText = (EditText) findViewById(R.id.et_searchlistview_listviews);
        // Initialising List Widget
        ListView listView = (ListView) findViewById(R.id.lv_activity_listview);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,listValuess);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        // Adding text watcher to searchTexxt
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence cs, int start, int count, int after) {
                ListViewMainActivity.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                startActivity(new Intent(this, CustomListActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, ExpandableListActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, SpiceExpandableListView.class));
                break;
            case 3:
                startActivity(new Intent(this, YouTubeMainActivity.class));
                break;
            default:
                Toast.makeText(this,"Position is : " + position, Toast.LENGTH_SHORT).show();
        }
    }
}
