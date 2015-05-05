package com.terry.viewpagerdemo.Modules.Discover;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.terry.viewpagerdemo.R;

import java.io.File;

//NOF(Network of Friends) Activity
public class NOFActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nof);

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle("朋友圈");
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("照相").setIcon(R.drawable.ic_action_camera).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getTitle().equals("照相")) {
            Toast.makeText(getBaseContext(), "照相机坏了", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}
