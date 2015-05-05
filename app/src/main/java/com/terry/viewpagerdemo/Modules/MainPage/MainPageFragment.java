package com.terry.viewpagerdemo.Modules.MainPage;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.terry.viewpagerdemo.BaseFragment;
import com.terry.viewpagerdemo.R;

import java.util.ArrayList;
import java.util.List;


public class MainPageFragment extends BaseFragment {

    final String Title1 = "中国建设银行";
    final String Title2 = "微信游戏";
    final String Title3 = "黄金梅";
    final String Title4 = "微信公众平台";
    final String Title5 = "订阅号";
    final String Title6 = "小萝莉";


    private List<MainPageItem> mainPageItemList;
    private MainPageAdapter mainPageAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_page, container, false);

        ListView listView = (ListView) v.findViewById(R.id.listView);
        mainPageItemList = GenerateDummyData();
        mainPageAdapter = new MainPageAdapter(this.getActivity().getBaseContext(), R.layout.layout_mainpage_item, mainPageItemList);

        listView.setAdapter(mainPageAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity().getBaseContext(), mainPageItemList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                if (menuInfo instanceof AdapterView.AdapterContextMenuInfo) {
                    AdapterView.AdapterContextMenuInfo OmenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
                    MainPageItem mainPageItem = mainPageItemList.get(OmenuInfo.position);
                    //System.err.println(mainPageItem.getName());

                    menu.setHeaderTitle(mainPageItem.getName());

                    //已读未读
                    if (mainPageItem.isOld()) {
                        menu.add(R.string.MainPageItemContextMenu_MarkAsNew);
                    } else {
                        menu.add(R.string.MainPageItemContextMenu_MarkAsOld);
                    }

                    //"微信公众平台"不允许取消关注
                    if (!mainPageItem.getName().startsWith(Title4)) {
                        menu.add(R.string.MainPageItemContextMenu_UnFocus);
                    }
                    menu.add(R.string.MainPageItemContextMenu_Remove);
                    menu.add(R.string.MainPageItemContextMenu_Slient);
                }
            }
        });
        return v;
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //右键菜单点击处理方法
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        MainPageItem mainPageItem = mainPageItemList.get(menuInfo.position);
        if (mainPageItem != null) {
            //Toast.makeText(getActivity().getBaseContext(), mainPageItemList.get(menuInfo.position).getName() + "````" + item.getTitle(), Toast.LENGTH_SHORT).show();
            CharSequence itemTitle = item.getTitle();
            if (itemTitle == getString(R.string.MainPageItemContextMenu_MarkAsOld) ||
                    (itemTitle == getString(R.string.MainPageItemContextMenu_MarkAsNew))) {
                mainPageItem.setOld(!mainPageItem.isOld());

            } else if (itemTitle == getString(R.string.MainPageItemContextMenu_UnFocus)) {

            } else if (itemTitle == getString(R.string.MainPageItemContextMenu_Remove)) {
                mainPageItemList.remove(menuInfo.position);

            } else if (itemTitle == getString(R.string.MainPageItemContextMenu_Slient)) {
                mainPageItem.setSlientState(mainPageItem.isSlientState()); //免打扰开关
            } else {
            }

            //刷新数据列表
            if (this.mainPageAdapter != null) {
                mainPageAdapter.notifyDataSetChanged();
            }
        }
        return super.onContextItemSelected(item);
    }

    private List<MainPageItem> GenerateDummyData() {
        ArrayList<MainPageItem> mainPageItemList = new ArrayList<MainPageItem>();
        for (int i = 0; i < 30; i++) {
            MainPageItem item = new MainPageItem();

            String title;
            String desc;
            int img;

            if (i % 5 == 0) {
                title = Title1;
                desc = "交易提醒";
                img = R.drawable.ic_mainpageitem_activity;
            } else if (i % 3 == 0) {
                title = Title2;
                desc = "注册送娘子，签到送风剑";
                img = R.drawable.ic_mainpageitem_method;
            } else if (i % 7 == 0) {
                title = Title3;
                desc = "震惊！马|航|MH370被发现，原来幕后真凶就是他";
                img = R.drawable.ic_mainpageitem_rt_essence;
            } else if (i % 17 == 0) {
                title = Title4;
                desc = "自定义菜单接口和素材管理接口向第三方平台旗下为认证订阅号开放";
                img = R.drawable.ic_mainpageitem_rt_jieyan;
                item.setSlientState(true);
            } else if (i % 37 == 0) {
                title = Title5;
                desc = "武汉吃货：炉鱼武汉第二店落户宜家荟聚，开业有你想象不到的折扣";
                img = R.drawable.ic_mainpageitem_rt_gossip;

            } else {
                title = Title6;
                desc = "你几么有空？";
                img = R.drawable.ic_mainpageitem_rt_all;
            }

            item.setOld(false);
            item.setName(title + i);
            item.setDescription(desc + i);
            item.setTip("下午 15:52");
            item.setIcon(img);
            mainPageItemList.add(item);
        }
        return mainPageItemList;
    }


}
