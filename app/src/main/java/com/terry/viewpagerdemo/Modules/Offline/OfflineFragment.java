package com.terry.viewpagerdemo.Modules.Offline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.terry.viewpagerdemo.BaseFragment;
import com.terry.viewpagerdemo.Framework.QuickAdapter.BaseAdapterHelper;
import com.terry.viewpagerdemo.Framework.QuickAdapter.QuickAdapter;
import com.terry.viewpagerdemo.R;

import java.util.ArrayList;
import java.util.List;


public class OfflineFragment extends BaseFragment {

    ListView listView;

    public static OfflineFragment newInstance() {
        return new OfflineFragment();
    }

    public OfflineFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_offline, container, false);

        listView = (ListView) v.findViewById(R.id.lvDownloadList);


        QuickAdapter<OfflineItem> adapter = new QuickAdapter<OfflineItem>(this.getActivity().getBaseContext(), R.layout.layout_download_item) {
            @Override
            protected void convert(BaseAdapterHelper helper, OfflineItem item) {
                helper.setText(R.id.url, item.getUrl())  // + "[" + item.getDownloadState().toString() + "]")
                        .setProgress(R.id.progressBar, item.getDownloadRate())
                        .setText(R.id.button, "暂停");
            }
        };

        listView.setAdapter(adapter);
        adapter.addAll(getDownloadFileList());

        return v;
    }


    private List<OfflineItem> getDownloadFileList() {
        List<OfflineItem> objList = new ArrayList<OfflineItem>();

        String pre = "http://192.168.1.27:9600/logs/";
        String[] files = new String[]{

                "AppLog.log",
                "AppLog.log.2015-04-24",
                "AppLog.log.2015-04-27",
                "AppLog.log.2015-04-28",
                "file.txt",
                "伊利集团学分制培训方案2012.doc",
                "佳腾积分制培训系统用户手册.docx",
                "佳腾积分制培训系统用户手册.Pdf",
                "大唐培训积分管理办法.docx",
                "大唐培训积分管理办法.Pdf",
                "大唐洛阳首阳山发电厂教育培训考核办法（修订2）.doc",
                "大唐洛阳首阳山发电厂教育培训考核办法（修订2）.Pdf",
                "大唐洛阳首阳山发电有限责任公司安全生产标准化规范及达标评级工作责任分工.doc",
                "大唐洛阳首阳山发电有限责任公司安全生产标准化规范及达标评级工作责任分工.Pdf",
                "宁波市公务员培训学分制管理办法(试行).doc",
                "宁波市公务员培训学分制管理办法(试行).Pdf",
                "排版正文：关于印发《大唐洛阳首阳山发电有限责任公司教育培训考核管理办法》的通知.doc",
                "新飞集团 培训管理手册(超详细).doc",
                "河南省电力公司全员培训考试积分制管理办法.doc",
                "河南省电力公司全员培训考试积分制管理办法.Pdf",
                "河南省行政机关公务员培训学分制管理办法(试行).doc",
                "河南省行政机关公务员培训学分制管理办法(试行).Pdf",
                "软件项目管理办法 第1部分 基本概念、行为准则和主要流程.docx",
                "软件项目管理办法 第1部分 基本概念、行为准则和主要流程.Pdf",
                "软件项目管理办法 第2部分 Product Backlog表的编制和维护.docx",
                "软件项目管理办法 第2部分 Product Backlog表的编制和维护.Pdf",
                "软件项目管理办法 第2部分 Sprint计划会议流程和规范.docx",
                "软件项目管理办法 第2部分 Sprint计划会议流程和规范.Pdf",
                "软件项目管理办法 第3部分 每日站会流程和规范.docx",
                "软件项目管理办法 第3部分 每日站会流程和规范.Pdf",
                "软件项目管理办法 第4部分 Sprint评审会议流程和规范.docx",
                "软件项目管理办法 第4部分 Sprint评审会议流程和规范.Pdf",
                "软件项目管理办法 第4部分 Sprint评审会议流程和规范【产品Backlog评估表】.docx",
                "软件项目管理办法 第4部分 Sprint评审会议流程和规范【产品Backlog评估表】.Pdf",
                "软件项目管理办法 第4部分 Sprint评审会议流程和规范【测试工作评估表】.docx",
                "软件项目管理办法 第4部分 Sprint评审会议流程和规范【测试工作评估表】.Pdf",
                "软件项目管理办法 第9部分 项目考核办法.docx",
                "软件项目管理办法 第9部分 项目考核办法.Pdf"};

        for (int i = 0; i < files.length; i++) {
            OfflineItem offlineItem = new OfflineItem();
            offlineItem.setUrl(pre + files[i]);
            offlineItem.setDownloadRate(10);
            //offlineItem.setDownloadState(OfflineItem.DownloadState.READY);
            objList.add(offlineItem);
        }

        return objList;
    }


}
