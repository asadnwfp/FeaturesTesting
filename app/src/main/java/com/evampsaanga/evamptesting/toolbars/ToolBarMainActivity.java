package com.evampsaanga.evamptesting.toolbars;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.evampsaanga.evamptesting.R;

/**
 * Created by root on 12/16/2015.
 */
public class ToolBarMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_mainactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_mainactivity_Toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true); // will Enable the action to home
        // actionBar.setHomeAsUpIndicator(R.mipmap.icon_right_arrow); // will let you chacnge the defualt back button
        actionBar.setIcon(R.mipmap.icon_money_transfer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menus,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                Log.d("ActionBarHome", "action bar clicked");
                return super.onOptionsItemSelected(item);
            case R.id.menu_miCompose:
                Toast.makeText(this,"Button 1 Pressed",Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
            case R.id.menu_miProfile:
                Toast.makeText(this,"Button 2 Pressed",Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
