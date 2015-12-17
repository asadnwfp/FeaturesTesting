package com.evampsaanga.evamptesting.listviews.spiceexpandablelistview;

import android.graphics.Bitmap;

/**
 * Created by root on 12/14/2015.
 */
public class SpiceChildGroup  {
    private Bitmap image;
    private String code = "";
    private String name = "";
    private int population = 0;

    public SpiceChildGroup (String code, String name, int population, Bitmap image) {
        super();
        this.code = code;
        this.name = name;
        this.population = population;
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
