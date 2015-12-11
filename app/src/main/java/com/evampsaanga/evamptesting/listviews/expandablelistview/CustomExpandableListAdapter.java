package com.evampsaanga.evamptesting.listviews.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.evampsaanga.evamptesting.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by root on 12/10/2015.
 */
public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    // Variables Required for Expandable listView.
    private Context context;
    private List<String> parentItems;
    private HashMap<String,List<String>> childItems;

    public CustomExpandableListAdapter(Context context, List<String> parentNames, HashMap<String,List<String>> childHashMap ){
        this.context = context;
        this.parentItems = parentNames;
        this.childItems = childHashMap;
    }

    @Override
    public int getGroupCount() {
        return  this.parentItems.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.childItems.get(this.parentItems.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.parentItems.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.childItems.get(this.parentItems.get(groupPosition))
                .get(childPosition);
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
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final String parentText = (String) getGroup(groupPosition);
        if(convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(R.layout.parentitem_expandablelist,null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.tv_parentitem_expandablelist);
        textView.setText(parentText);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition,childPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.childitem_expandablelist, null);
        }
        TextView childItem = (TextView) convertView.findViewById(R.id.tv_childitem_expandablelist);
        childItem.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
