package com.evampsaanga.evamptesting.listviews.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.evampsaanga.evamptesting.R;

import java.util.ArrayList;

/**
 * Created by root on 12/9/2015.
 */
public class CustomListAdapter extends ArrayAdapter <CustomListModel> {
    public CustomListAdapter(Context context,  ArrayList<CustomListModel> customListModels) {
        super(context, 0, customListModels);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomListModel model = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.customlistview, parent, false);
        }
        // Lookup view for data population
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgviiew_customlistview_LeftIcons);
        TextView textView = (TextView) convertView.findViewById(R.id.tv_customlistview);
        // Initialize Views
        imageView.setImageBitmap(model.getImgLeft());
        textView.setText(model.getText());
        return convertView;
    }
}
