package com.evampsaanga.evamptesting.listviews.youtubelistivew;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.widget.ExpandableListView;

import com.evampsaanga.evamptesting.R;

import java.util.ArrayList;

/**
 * Created by root on 12/14/2015.
 */
public class YouTubeMainActivity extends AppCompatActivity implements
        SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    private SearchView search;
    private MyListAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<Continent> continentList = new ArrayList<Continent>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spiceexpandablelistview_listview);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        search = (SearchView) findViewById(R.id.sv_spiceexpandablelistview_listview_SearchView);
        search.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        search.setIconifiedByDefault(false);
        search.setOnQueryTextListener(this);
        search.setOnCloseListener(this);

        // display the list
        displayList();
        // expand all Groups
        expandAll();

    }


    // method to expand all groups
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            myList.expandGroup(i);
        }
    }

    // method to expand all groups
    private void displayList() {

        // display the list
        loadSomeData();

        // get reference to the ExpandableListView
        myList = (ExpandableListView) findViewById(R.id.explv_spiceexpandablelistview_listview_Expandable);
        // create the adapter by passing your ArrayList data
        listAdapter = new MyListAdapter(YouTubeMainActivity.this, continentList);
        // attach the adapter to the list
        myList.setAdapter(listAdapter);

    }

    private void loadSomeData() {
        ArrayList<Country> countryList = new ArrayList<Country>();
        Country country = new Country("BMU", "Bermuda", 10000000);
        countryList.add(country);
        country = new Country("CAN", "Canada", 20000000);
        countryList.add(country);
        country = new Country("USA", "United States", 50000000);
        countryList.add(country);

        Continent continent = new Continent("North America", countryList);
        continentList.add(continent);

        countryList = new ArrayList<Country>();
        country = new Country("CHN", "China", 10000100);
        countryList.add(country);
        country = new Country("JPN", "Japan", 20000200);
        countryList.add(country);
        country = new Country("THA", "Thailand", 50000500);
        countryList.add(country);

        continent = new Continent("Asia", countryList);
        continentList.add(continent);
    }

    @Override
    public boolean onClose() {
        // TODO Auto-generated method stub
        listAdapter.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        // TODO Auto-generated method stub
        listAdapter.filterData(newText);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        // TODO Auto-generated method stub
        listAdapter.filterData(query);
        expandAll();
        return false;
    }

}
