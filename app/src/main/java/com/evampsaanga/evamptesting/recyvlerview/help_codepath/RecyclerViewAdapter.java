package com.evampsaanga.evamptesting.recyvlerview.help_codepath;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.evampsaanga.evamptesting.R;

import java.util.List;

/**
 * Created by root on 12/17/2015.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<RecyclerModel> modelList;

    public RecyclerViewAdapter(List<RecyclerModel> model) {
        this.modelList = model;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.custom_row_recyvlerview_mainactivity, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        RecyclerModel contact = modelList.get(position);

        // Set item views based on the data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(contact.getName());

        Button button = viewHolder.messageButton;

        if (contact.isOnline()) {
            button.setText("Message");
            button.setEnabled(true);
        }
        else {
            button.setText("Offline");
            button.setEnabled(false);
        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
}
