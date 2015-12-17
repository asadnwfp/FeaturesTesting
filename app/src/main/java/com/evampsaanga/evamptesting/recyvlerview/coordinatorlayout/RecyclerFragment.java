package com.evampsaanga.evamptesting.recyvlerview.coordinatorlayout;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evampsaanga.evamptesting.R;
import com.evampsaanga.evamptesting.recyvlerview.RecyclarModel;
import com.evampsaanga.evamptesting.recyvlerview.RecyclerAdapter;

/**
 * Created by root on 12/17/2015.
 */
public class RecyclerFragment extends Fragment {

    public final static String ITEMS_COUNT_KEY = "PartThreeFragment$ItemsCount";
    private static int itemCount;

    public static RecyclerFragment createInstance(int itemsCount, int items) {
        itemsCount = items;
        RecyclerFragment partThreeFragment = new RecyclerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ITEMS_COUNT_KEY, itemsCount);
        partThreeFragment.setArguments(bundle);
        return partThreeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_recyclerview, container, false);
        setupRecyclerView(recyclerView);
        return recyclerView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerAdapter adapter = new RecyclerAdapter(RecyclarModel.getModle(10, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
