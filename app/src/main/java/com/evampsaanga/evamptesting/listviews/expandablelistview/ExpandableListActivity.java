package com.evampsaanga.evamptesting.listviews.expandablelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.evampsaanga.evamptesting.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by root on 12/10/2015.
 */
public class ExpandableListActivity extends AppCompatActivity {
    private ExpandableListView listView;
    private List<String> parentNames;
    private HashMap<String,List<String>> childHashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandablelistactivity_listviews);
        // Initialise values for lis
        initializeListValues();
        listView = (ExpandableListView) findViewById(R.id.expLv_expandablelistview_listview);
        CustomExpandableListAdapter adapter = new CustomExpandableListAdapter(this,parentNames,childHashMap);
        listView.setAdapter(adapter);
    }

    private void initializeListValues() {
        parentNames = new ArrayList<String>();
        childHashMap = new HashMap<String, List<String>>();

        // Adding child data
        parentNames.add("Top 250");
        parentNames.add("Now Showing");
        parentNames.add("Coming Soon..");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        childHashMap.put(parentNames.get(0), top250); // Header, Child data
        childHashMap.put(parentNames.get(1), nowShowing);
        childHashMap.put(parentNames.get(2), comingSoon);
    }
}
