package com.evampsaanga.evamptesting.toolbars;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.evampsaanga.evamptesting.R;

/**
 * Created by root on 12/16/2015.
 */
public class ReusingToolBar extends AppCompatActivity {
    private static final String TAG = "DebugActionBar";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_reuse);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_mainactivity_Toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Reusing ToolBar");
        actionBar.setDisplayUseLogoEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.d(TAG, "Action Bar Clicked");
            return super.onOptionsItemSelected(item);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
