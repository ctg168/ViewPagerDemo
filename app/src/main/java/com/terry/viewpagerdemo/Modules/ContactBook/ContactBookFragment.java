package com.terry.viewpagerdemo.Modules.ContactBook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.terry.viewpagerdemo.BaseFragment;
import com.terry.viewpagerdemo.R;

public class ContactBookFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact_book, container, false);
    }

}
