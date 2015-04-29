package com.terry.viewpagerdemo.Modules.MainPage;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_page, container, false);

        ListView listView = (ListView) v.findViewById(R.id.listView);
        final List<MainPageItem> mainPageItemList = GenerateDummyData();

        MainPageAdapter mainPageAdapter = new MainPageAdapter(this.getActivity().getBaseContext(), R.layout.layout_mainpage_item, mainPageItemList);
        listView.setAdapter(mainPageAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity().getBaseContext(), mainPageItemList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                return false;
            }
        });

        listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.setHeaderTitle("选中项的名字");
                menu.add("标为未读");
                menu.add("取消关注");
                menu.add("删除该聊天");
            }
        });


        return v;
    }


    private List<MainPageItem> GenerateDummyData() {
        ArrayList<MainPageItem> mainPageItemList = new ArrayList<MainPageItem>();
        for (int i = 0; i < 100; i++) {
            MainPageItem item = new MainPageItem();
            item.setName("中国建设银行" + i);
            item.setDescription("中国建设银行：交易提醒" + i);
            item.setTip("tip" + i);
            item.setIcon(R.drawable.main_app_rechange_press);
            mainPageItemList.add(item);
        }
        return mainPageItemList;
    }


}
