package com.terry.viewpagerdemo.Modules.My;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.terry.viewpagerdemo.BaseFragment;
import com.terry.viewpagerdemo.Framework.DownloadManager.utils.MyIntents;
import com.terry.viewpagerdemo.Framework.DownloadManager.utils.Utils;
import com.terry.viewpagerdemo.R;
import com.terry.viewpagerdemo.Util.DownloadListActivity;


public class MyFragment extends BaseFragment {

    private int urlIndex = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        //button click add
        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DownloadListActivity.class));

            }
        });


        return view;








    }

}
