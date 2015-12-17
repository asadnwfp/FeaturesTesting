package com.evampsaanga.evamptesting.listviews.spiceexpandablelistview;

import java.util.ArrayList;

/**
 * Created by root on 12/14/2015.
 */
public class SpiceParentGroup {
    private String continentName;
    private ArrayList<SpiceChildGroup> countries;

    public SpiceParentGroup(String continentName, ArrayList<SpiceChildGroup> countries) {
        this.continentName = continentName;
        this.countries = countries;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public ArrayList<SpiceChildGroup> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<SpiceChildGroup> countries) {
        this.countries = countries;
    }
}
