package com.jet2006.LearnApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    private void ShowStep(String stepMsg) {
        System.err.printf(stepMsg + "[terry]" + this.getClass().getSimpleName());
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        ShowStep("BaseFragment.onHiddenChanged");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ShowStep("BaseFragment.onActivityResult");
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        ShowStep("BaseFragment.onInflate");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ShowStep("BaseFragment.onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShowStep("BaseFragment.onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ShowStep("BaseFragment.onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ShowStep("BaseFragment.onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        ShowStep("BaseFragment.onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        ShowStep("BaseFragment.onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        ShowStep("BaseFragment.onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        ShowStep("BaseFragment.onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        ShowStep("BaseFragment.onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        ShowStep("BaseFragment.onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        ShowStep("BaseFragment.onDetach");
        super.onDetach();
    }
}
