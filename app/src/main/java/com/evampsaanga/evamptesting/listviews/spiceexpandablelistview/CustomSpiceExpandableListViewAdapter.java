package com.evampsaanga.evamptesting.listviews.spiceexpandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.evampsaanga.evamptesting.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by root on 12/14/2015.
 */
public class CustomSpiceExpandableListViewAdapter extends BaseExpandableListAdapter {
    // private variable required for SpiceExpandableListView
    private ArrayList<SpiceParentGroup> originalList;
    private ArrayList<SpiceParentGroup> continentList;
    private Context context;

    public CustomSpiceExpandableListViewAdapter(Context context,ArrayList<SpiceParentGroup> continentList) {
        this.context = context;
        // Must Use .addAll to perform Search.
        this.continentList =  new ArrayList<SpiceParentGroup>();
        this.continentList.addAll(continentList);
        this.originalList =  new ArrayList<SpiceParentGroup>();;
        this.originalList.addAll(continentList);
    }

    @Override
    public int getGroupCount() {
        return continentList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<SpiceChildGroup> childGroups = continentList.get(groupPosition).getCountries();
        return childGroups.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return continentList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<SpiceChildGroup> childGroups = continentList.get(groupPosition).getCountries();
        return childGroups.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        SpiceParentGroup parentGroup = (SpiceParentGroup) getGroup(groupPosition);
        if(convertView == null){
           // convertView = LayoutInflater.from(context).inflate(R.layout.groupview_spiceexpandablelistivew, parent, false);
           LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.groupview_spiceexpandablelistivew,null);
        }
        TextView groupHeading = (TextView) convertView.findViewById(R.id.tv_groupview_spiceexpandablelistivew_GroupHeading);
        groupHeading.setText(parentGroup.getContinentName().trim());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        SpiceChildGroup childGroup = (SpiceChildGroup) getChild(groupPosition, childPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.childview_spiceexpandablelistivew, null);
        }
        ImageView img = (ImageView) convertView.findViewById(R.id.imgv_childview_spiceexpandablelistivew_Image);
        TextView code = (TextView) convertView.findViewById(R.id.tv_childview_spiceexpandablelistivew_Code);
        TextView name = (TextView) convertView.findViewById(R.id.tv_childview_spiceexpandablelistivew_Name);
        TextView population = (TextView) convertView.findViewById(R.id.tv_childview_spiceexpandablelistivew_Population);

        img.setImageBitmap(childGroup.getImage());
        code.setText(childGroup.getCode().trim());
        name.setText(childGroup.getName().trim());
        //population.setText(String.valueOf(childGroup.getPopulation()));
        population.setText(NumberFormat.getNumberInstance(Locale.US).format(childGroup.getPopulation()));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filterData (String query){
        query = query.toLowerCase();
        continentList.clear();
        if(query.isEmpty()){
            continentList.addAll(originalList);
        }else{
            for(SpiceParentGroup parentGroup: originalList){
                ArrayList<SpiceChildGroup> childGroups = parentGroup.getCountries();
                ArrayList<SpiceChildGroup> newChildGroups = new ArrayList<SpiceChildGroup> ();
                for (SpiceChildGroup childGroup: childGroups){
                    if(childGroup.getCode().toLowerCase().contains(query) ||
                    childGroup.getName().toLowerCase().contains(query) ){
                        newChildGroups.add(childGroup);
                    }
                }
                if(newChildGroups.size()>0){
                    SpiceParentGroup nParentGroup = new SpiceParentGroup(parentGroup.getContinentName(),newChildGroups);
                    continentList.add(nParentGroup);
                }
            }
        }
        notifyDataSetChanged();
    }
}
