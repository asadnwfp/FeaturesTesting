package com.evampsaanga.evamptesting.listviews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.evampsaanga.evamptesting.R;
import com.evampsaanga.evamptesting.listviews.customlistview.CustomListActivity;

/**
 * Created by root on 12/9/2015.
 */
public class ListViewMainActivity
        extends AppCompatActivity
        implements AdapterView.OnItemClickListener{
    private String [] listValuess = {"Custom List Activity","Value 2","Value 3","Value 4","Value 5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_main);
        ListView listView = (ListView) findViewById(R.id.lv_activity_listview);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,listValuess);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                startActivity(new Intent(this, CustomListActivity.class));
                break;
            case 1:
                Toast.makeText(this,"Position is : " + position, Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this,"Position is : " + position, Toast.LENGTH_SHORT).show();
        }
    }
}
