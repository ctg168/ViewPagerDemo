package com.jet2006.LearnApp.Modules.Discover;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jet2006.LearnApp.BaseFragment;
import com.jet2006.LearnApp.R;


public class DiscoverFragment extends BaseFragment {

    View itemNof;

    TextView tvTitle222;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_discover, container, false);

        tvTitle222 = (TextView) v.findViewById(R.id.txtTitle);

        itemNof = v.findViewById(R.id.leftBtnMyInfo);
        itemNof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getActivity().getBaseContext(),"abc",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity().getBaseContext(), NOFActivity.class));
            }
        });

        Typeface iconfont = Typeface.createFromAsset(getActivity().getAssets(),"material_icons.ttf");
        tvTitle222.setTypeface(iconfont);

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
}
