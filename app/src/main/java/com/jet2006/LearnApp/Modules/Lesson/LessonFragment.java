package com.jet2006.LearnApp.Modules.Lesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jet2006.Framework.net.WebApiCaller;
import com.jet2006.LearnApp.BaseFragment;
import com.jet2006.LearnApp.LogUtil;
import com.jet2006.LearnApp.R;

import java.util.List;


public class LessonFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lesson, container, false);

        // 基本对象返回
        WebApiCaller<JetUser> caller1 = new WebApiCaller<JetUser>() {
            @Override
            public void OnResponse(JetUser obj) {
                //tvCD.setText(String.valueOf(obj.Id));
                //textView.setText(obj.ObjectName);
                super.OnResponse(obj);
                LogUtil.e("terry", obj.ObjectName);
            }
        };

        Object[] params = new Object[]{5, "zxx"};
        caller1.InvokeMethod(view.getContext(), "JetTest", "Test2", params, JetUser.class);

        return view;
    }
}
