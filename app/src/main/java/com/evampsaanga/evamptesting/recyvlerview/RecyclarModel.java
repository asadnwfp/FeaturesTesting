package com.evampsaanga.evamptesting.recyvlerview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.evampsaanga.evamptesting.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 12/17/2015.
 */
public class RecyclarModel {
    private String firstName;
    private Bitmap image;
    private static int productId = 0;

    public RecyclarModel(String firstName, Bitmap image) {
        this.firstName = firstName;
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }


    public Bitmap getImage() {
        return image;
    }

    public static int getProductId() {
        return productId;
    }

    public static List<RecyclarModel> getModle(int rowCount, Bitmap image){
        List<RecyclarModel> modle = new ArrayList<>();
        for (int i=0; i<rowCount; i++){
            modle.add(new RecyclarModel("image"+ ++productId, image));
        }
        return modle;
    }
}
