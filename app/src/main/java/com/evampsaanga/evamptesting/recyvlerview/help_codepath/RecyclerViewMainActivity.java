package com.evampsaanga.evamptesting.recyvlerview.help_codepath;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.evampsaanga.evamptesting.R;

/**
 * Created by root on 12/17/2015.
 */
public class RecyclerViewMainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_mainactivity);
        recycler = (RecyclerView) findViewById(R.id.rv_recyclerview_mainactivity_Recycler);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(RecyclerModel.createContactsList(20));
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
