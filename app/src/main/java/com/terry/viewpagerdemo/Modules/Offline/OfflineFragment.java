package com.terry.viewpagerdemo.Modules.Offline;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.terry.viewpagerdemo.BaseActivity;
import com.terry.viewpagerdemo.BaseFragment;
import com.terry.viewpagerdemo.Framework.ThinDownloadManager.DefaultRetryPolicy;
import com.terry.viewpagerdemo.Framework.ThinDownloadManager.DownloadManager;
import com.terry.viewpagerdemo.Framework.ThinDownloadManager.DownloadRequest;
import com.terry.viewpagerdemo.Framework.ThinDownloadManager.DownloadStatusListener;
import com.terry.viewpagerdemo.Framework.QuickAdapter.BaseAdapterHelper;
import com.terry.viewpagerdemo.Framework.QuickAdapter.QuickAdapter;
import com.terry.viewpagerdemo.Framework.ThinDownloadManager.ThinDownloadManager;
import com.terry.viewpagerdemo.FullscreenVlcPlayer;
import com.terry.viewpagerdemo.R;

import org.videolan.libvlc.Media;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class OfflineFragment extends BaseFragment {

    List<OfflineItem> OfflineList;

    //同时下载的最大数量
    private int maxItem = 5;

    private static final int DOWNLOAD_THREAD_POOL_SIZE = 4;
    private ThinDownloadManager downloadManager;

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

        downloadManager = new ThinDownloadManager(DOWNLOAD_THREAD_POOL_SIZE);
        OfflineList = new ArrayList<OfflineItem>();
        FillList();

        QuickAdapter<OfflineItem> adapter = new QuickAdapter<OfflineItem>(this.getActivity().getBaseContext(), R.layout.layout_download_item) {
            @Override
            protected void convert(BaseAdapterHelper helper, final OfflineItem item) {
                helper.setText(R.id.url, item.getUrl())  // + "[" + item.getDownloadState().toString() + "]")
                        .setProgress(R.id.progressBar, item.getDownloadRate())
                        .setText(R.id.button, "开始");

                Button btnDownload = helper.getView(R.id.button);
                final ProgressBar progressBar = helper.getView(R.id.progressBar);

                btnDownload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity().getBaseContext(), item.getStoreFileName() + "开始下载!!", Toast.LENGTH_SHORT).show();
                        DownloadFileItem(item, progressBar);
                    }
                });
            }
        };

        listView.setAdapter(adapter);
        adapter.clear();

        adapter.addAll(OfflineList);

        return v;
    }


    private void FillList() {

        String pre = "http://192.168.1.27:9600/logs/";
        String[] files = new String[]{
//                "AppLog.log",
//                "AppLog.log.2015-04-24",
//                "AppLog.log.2015-04-27",
                "001.docx",
                "cde.flv",
                "软件项目管理办法 第9部分 项目考核办法.txt",
//                "伊利集团学分制培训方案2012.doc",
//                "佳腾积分制培训系统用户手册.docx",
//                "佳腾积分制培训系统用户手册.Pdf",
//                "大唐培训积分管理办法.docx",
//                "大唐培训积分管理办法.Pdf",
//                "大唐洛阳首阳山发电厂教育培训考核办法（修订2）.doc",
//                "大唐洛阳首阳山发电厂教育培训考核办法（修订2）.Pdf",
//                "大唐洛阳首阳山发电有限责任公司安全生产标准化规范及达标评级工作责任分工.doc",
//                "大唐洛阳首阳山发电有限责任公司安全生产标准化规范及达标评级工作责任分工.Pdf",
//                "宁波市公务员培训学分制管理办法(试行).doc",
//                "宁波市公务员培训学分制管理办法(试行).Pdf",
//                "排版正文：关于印发《大唐洛阳首阳山发电有限责任公司教育培训考核管理办法》的通知.doc",
//                "新飞集团 培训管理手册(超详细).doc",
//                "河南省电力公司全员培训考试积分制管理办法.doc",
//                "河南省电力公司全员培训考试积分制管理办法.Pdf",
//                "河南省行政机关公务员培训学分制管理办法(试行).doc",
//                "河南省行政机关公务员培训学分制管理办法(试行).Pdf",
//                "软件项目管理办法 第1部分 基本概念、行为准则和主要流程.docx",
//                "软件项目管理办法 第1部分 基本概念、行为准则和主要流程.Pdf",
//                "软件项目管理办法 第2部分 Product Backlog表的编制和维护.docx",
//                "软件项目管理办法 第2部分 Product Backlog表的编制和维护.Pdf",
//                "软件项目管理办法 第2部分 Sprint计划会议流程和规范.docx",
//                "软件项目管理办法 第2部分 Sprint计划会议流程和规范.Pdf",
//                "软件项目管理办法 第3部分 每日站会流程和规范.docx",
//                "软件项目管理办法 第3部分 每日站会流程和规范.Pdf",
//                "软件项目管理办法 第4部分 Sprint评审会议流程和规范.docx",
//                "软件项目管理办法 第4部分 Sprint评审会议流程和规范.Pdf",
//                "软件项目管理办法 第4部分 Sprint评审会议流程和规范【产品Backlog评估表】.docx",
//                "软件项目管理办法 第4部分 Sprint评审会议流程和规范【产品Backlog评估表】.Pdf",
//                "软件项目管理办法 第4部分 Sprint评审会议流程和规范【测试工作评估表】.docx",
//                "软件项目管理办法 第4部分 Sprint评审会议流程和规范【测试工作评估表】.Pdf",
//                "软件项目管理办法 第9部分 项目考核办法.docx",
//                "软件项目管理办法 第9部分 项目考核办法.Pdf"
        };

        for (int i = 0; i < files.length; i++) {
            OfflineItem offlineItem = new OfflineItem();
            offlineItem.setId(i);
            offlineItem.setUrl(pre + files[i]);
            offlineItem.setDownloadRate(10);
            offlineItem.setStoreFileName(files[i]);
            OfflineList.add(offlineItem);
        }
    }

    private void DownloadFileItem(final OfflineItem offlineItem, final ProgressBar progressBar) {
        Uri downloadUri = Uri.parse(offlineItem.getUrl());

        final String storeFileName = this.getActivity().getBaseContext().getExternalCacheDir().toString() + "/" + offlineItem.getStoreFileName();
        final Uri destinationUri = Uri.parse(storeFileName);

        DownloadRequest downloadRequest = new DownloadRequest(downloadUri)
                .addCustomHeader("Accept-Charset", "UTF-8")
                .setRetryPolicy(new DefaultRetryPolicy())
                .setDestinationURI(destinationUri).setPriority(DownloadRequest.Priority.HIGH)
                .setDownloadListener(new DownloadStatusListener() {
                    @Override
                    public void onDownloadComplete(int id) {
                        Toast.makeText(getActivity().getApplication(), "download complete", Toast.LENGTH_SHORT).show();

                        //如果下载的flv文件，直接播放
                        if (storeFileName.endsWith(".flv")) {
                            Intent toFullscreen = new Intent(getActivity(), FullscreenVlcPlayer.class);
                            Bundle b = new Bundle();

                            //String url1 = "http://192.168.1.27:9600/logs/" + "bcd.flv"; //远程视频
                            //String url2 = getActivity().getBaseContext().getExternalCacheDir().toString() + "/" + "cde.flv"; //本地视频

                            // Pass the url from the input to the player
                            b.putString("url", String.valueOf(destinationUri));
                            toFullscreen.putExtras(b); //Put your id to your next Intent
                            startActivity(toFullscreen);
                        }
                    }

                    @Override
                    public void onDownloadFailed(int id, int errorCode, String errorMessage) {
                        Toast.makeText(getActivity().getApplication(), "download failed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onProgress(int id, long totalBytes, long downlaodedBytes, int progress) {
                        progressBar.setProgress(progress);
                    }
                });
        this.downloadManager.add(downloadRequest);
    }

}
