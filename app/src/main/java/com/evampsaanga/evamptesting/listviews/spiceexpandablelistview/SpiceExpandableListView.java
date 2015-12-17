package com.evampsaanga.evamptesting.listviews.spiceexpandablelistview;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.widget.ExpandableListView;

import com.evampsaanga.evamptesting.R;

import java.util.ArrayList;

/**
 * Created by root on 12/14/2015.
 * MainLink for resource
 * https://www.youtube.com/watch?v=rhNZpFdLJFQ
 */
public class SpiceExpandableListView
        extends AppCompatActivity
        implements SearchView.OnQueryTextListener,
        SearchView.OnCloseListener {

    private SearchView searchView;
    private ExpandableListView expandableListView;
    private ArrayList<SpiceParentGroup> spiceParentGroups;
    private CustomSpiceExpandableListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spiceexpandablelistview_listview);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        declareWidgets();
        // getting SearchManager

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
        initializeComponents();
        expandAll();

    }

    private void declareWidgets() {
        // method to declare private components of the class
        // Declaration of Widgets
        searchView = (SearchView) findViewById(R.id.sv_spiceexpandablelistview_listview_SearchView);
        expandableListView = (ExpandableListView) findViewById(R.id.explv_spiceexpandablelistview_listview_Expandable);
        spiceParentGroups = new ArrayList<SpiceParentGroup>();
    }

    private void initializeComponents() {
        // setCustomAdapter for Expandable List View.
        loadSomeData();
        adapter = new CustomSpiceExpandableListViewAdapter(SpiceExpandableListView.this, spiceParentGroups );
        expandableListView.setAdapter(adapter);
    }

    private void loadSomeData() {
        Bitmap image = BitmapFactory.decodeResource(getResources(),R.mipmap.icon_money_transfer);
        ArrayList<SpiceChildGroup> childGroups= new ArrayList<SpiceChildGroup>();
        SpiceChildGroup spiceChild = new SpiceChildGroup("BMU", "Bermuda", 10000000,image);
        childGroups.add(spiceChild);
        spiceChild = new SpiceChildGroup("CAN", "Canada", 20000000,image);
        childGroups.add(spiceChild);
        spiceChild = new SpiceChildGroup("USA", "United States", 50000000,image);
        childGroups.add(spiceChild);

        SpiceParentGroup parentGroup = new SpiceParentGroup("North America", childGroups);
        spiceParentGroups.add(parentGroup);

        childGroups = new ArrayList<SpiceChildGroup>();
        spiceChild = new SpiceChildGroup("CHN", "China", 10000100,image);
        childGroups.add(spiceChild);
        spiceChild = new SpiceChildGroup("JPN", "Japan", 20000200,image);
        childGroups.add(spiceChild);
        spiceChild = new SpiceChildGroup("THA", "Thailand", 50000500,image);
        childGroups.add(spiceChild);

        parentGroup = new SpiceParentGroup("Asia", childGroups);
        spiceParentGroups.add(parentGroup);
    }

    private void expandAll() {
        int count = adapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            expandableListView.expandGroup(i);
        }
    }

    @Override
    public boolean onClose() {
        adapter.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        adapter.filterData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filterData(newText);
        expandAll();
        return false;
    }
}
