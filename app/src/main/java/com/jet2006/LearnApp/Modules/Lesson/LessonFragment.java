package com.jet2006.LearnApp.Modules.Lesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jet2006.Framework.net.WebApiCaller;
import com.jet2006.LearnApp.BaseFragment;
import com.jet2006.LearnApp.R;

import java.util.List;


public class LessonFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lesson, container, false);





        return view;
    }

    private List<Lesson> GetLessonList(){
        WebApiCaller<Lesson> caller = new WebApiCaller<Lesson>();

//
//        Object[] params = { 1, 2 };
//        caller.InvokeMethod(getActivity(),"WhTest", "Test1", params, JetUser.class);

        return  null;
    }


}
