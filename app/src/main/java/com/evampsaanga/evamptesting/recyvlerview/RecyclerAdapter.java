package com.evampsaanga.evamptesting.recyvlerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.evampsaanga.evamptesting.R;

import java.util.List;

/**
 * Created by root on 12/17/2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<RecyclarModel> modleList;

    public RecyclerAdapter(List<RecyclarModel> modle) {
        this.modleList = modle;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.customrowitem_recyclerview_mian,parent,false);
        ViewHolder holder = new ViewHolder(convertView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RecyclarModel modle = modleList.get(position);

        ImageView image = holder.img;
        TextView textView = holder.textView;

        textView.setText(modle.getFirstName());
        image.setImageBitmap(modle.getImage());
    }

    @Override
    public int getItemCount() {
        return modleList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.image_customRow_recyclerview_Image);
            textView = (TextView) itemView.findViewById(R.id.tv_customRow_recyclerview_Text);
        }
    }
}
