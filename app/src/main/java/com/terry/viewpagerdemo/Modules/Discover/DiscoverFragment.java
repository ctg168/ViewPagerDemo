package com.terry.viewpagerdemo.Modules.Discover;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.terry.viewpagerdemo.BaseFragment;
import com.terry.viewpagerdemo.R;


public class DiscoverFragment extends BaseFragment {

    View itemNof;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_discover, container, false);

        itemNof = v.findViewById(R.id.leftBtnMyInfo);
        itemNof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getActivity().getBaseContext(),"abc",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity().getBaseContext(), NOFActivity.class));
            }
        });

        return v;
    }


}
