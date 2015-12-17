package com.evampsaanga.evamptesting.recyvlerview;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.evampsaanga.evamptesting.R;

import java.util.List;

/**
 * Created by root on 12/17/2015.
 */
public class RecyclerViewMainActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_mainactivity);
        recyclerView = (RecyclerView) findViewById(R.id.rv_recyclerview_mainactivity_Recycler);
        RecyclerAdapter adapter = new RecyclerAdapter(RecyclarModel.getModle(20, BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher)));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
