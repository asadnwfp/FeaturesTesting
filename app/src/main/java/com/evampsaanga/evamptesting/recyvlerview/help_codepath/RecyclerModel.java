package com.evampsaanga.evamptesting.recyvlerview.help_codepath;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 12/17/2015.
 */
public class RecyclerModel {
    private String mName;
    private boolean mOnline;

    public RecyclerModel(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static List<RecyclerModel> createContactsList(int numContacts) {
        List<RecyclerModel> contacts = new ArrayList<RecyclerModel>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new RecyclerModel("Person " + ++lastContactId, i <= numContacts / 2));
        }

        return contacts;
    }
}
