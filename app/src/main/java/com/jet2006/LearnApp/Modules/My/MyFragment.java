package com.jet2006.LearnApp.Modules.My;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jet2006.LearnApp.BaseFragment;
import com.jet2006.LearnApp.R;
import com.jet2006.LearnApp.Misc.DownloadListActivity;


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
