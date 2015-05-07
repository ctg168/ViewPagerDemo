package com.terry.viewpagerdemo.Modules.Discover;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.terry.viewpagerdemo.Framework.QuickAdapter.BaseAdapterHelper;
import com.terry.viewpagerdemo.Framework.QuickAdapter.QuickAdapter;
import com.terry.viewpagerdemo.FullscreenVlcPlayer;
import com.terry.viewpagerdemo.R;

import java.util.ArrayList;
import java.util.List;

//NOF(Network of Friends) Activity
public class NOFActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nof);

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle("朋友圈");
            //actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ListView lvNofList = (ListView) this.findViewById(R.id.lvNofList);
        QuickAdapter<NOFItem> adapter = new QuickAdapter<NOFItem>(this, R.layout.layout_nof_item) {
            @Override
            protected void convert(BaseAdapterHelper helper, NOFItem item) {
                helper.setImageResource(R.id.imgNOFAvatar, item.getAvaterImg())
                        .setText(R.id.tvNOFName, item.getName())
                        .setText(R.id.tvNOFDesc, item.getContent())
                        .setImageResource(R.id.imgNOFCenterImage, item.getCenterImg())
                        .setText(R.id.tvNOFtime, item.getTime())
                        .setTextColor(R.id.tvNOFtime, Color.RED);
            }
        };

        lvNofList.setAdapter(adapter);

        adapter.addAll(getDummyData());
    }

    private List<NOFItem> getDummyData() {
        List<NOFItem> objList = new ArrayList<NOFItem>();

        for (int i = 0; i < 30; i++) {
            NOFItem nofItem = new NOFItem();
            nofItem.setAvaterImg(R.drawable.ic_mainpageitem_activity);
            nofItem.setName("喜洋洋" + i);
            nofItem.setContent("终于开花了" + i);
            nofItem.setTime("12:33");
            nofItem.setCenterImg(R.drawable.mmexport1430886412106);
            objList.add(nofItem);
        }
        return objList;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("照相").setIcon(R.drawable.ic_action_camera).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getTitle().equals("照相")) {
            //Toast.makeText(getBaseContext(), "照相机坏了", Toast.LENGTH_SHORT).show();

            Intent toFullscreen = new Intent(NOFActivity.this, FullscreenVlcPlayer.class);
            Bundle b = new Bundle();

            String url1 = "http://192.168.1.27:9600/logs/" + "bcd.flv"; //远程视频
            String url2 = this.getBaseContext().getExternalCacheDir().toString() + "/" + "cde.flv"; //本地视频

            // Pass the url from the input to the player
            b.putString("url", url2);
            toFullscreen.putExtras(b); //Put your id to your next Intent
            startActivity(toFullscreen);
        }
        return super.onOptionsItemSelected(item);
    }

}
