package com.evampsaanga.evamptesting.listviews.customlistview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.evampsaanga.evamptesting.R;

import java.util.ArrayList;

/**
 * Created by root on 12/9/2015.
 */
public class CustomListActivity
        extends AppCompatActivity
        implements AdapterView.OnItemClickListener{
    private ArrayList<CustomListModel> listModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlistacitivity);
        ListView listView = (ListView) findViewById(R.id.lv_customlistactivity_customlistview);
        //Declaring and creating Array list for CustomValues
        createCustomListModels();
        CustomListAdapter adapter = new CustomListAdapter(this,listModels);
        listView.setAdapter(adapter);
    }

    private void createCustomListModels() {
        String [] listValues  = {"Bill Payments","Money Transfer","Easy Load", "Payments"};
        listModels = new ArrayList<>();
        // Creating a static Bitmap Resource for all the icons
        Bitmap bMap = BitmapFactory.decodeResource(getResources(),R.mipmap.icon_money_transfer);
        for(String value:listValues){
            CustomListModel model = new CustomListModel();
            model.setImgLeft(bMap);
            model.setText(value);
            listModels.add(model);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
