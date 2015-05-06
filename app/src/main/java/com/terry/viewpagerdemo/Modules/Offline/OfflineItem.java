package com.terry.viewpagerdemo.Modules.Offline;

public class OfflineItem {
    String Url;
    String StoreFileName;
    int DownloadRate;
    //static DownloadState DownloadState;

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getStoreFileName() {
        return StoreFileName;
    }

    public void setStoreFileName(String storeFileName) {
        StoreFileName = storeFileName;
    }

//    public OfflineItem.DownloadState getDownloadState() {
//        return DownloadState;
//    }
//
//    public void setDownloadState(OfflineItem.DownloadState downloadState) {
//        DownloadState = downloadState;
//    }

    public int getDownloadRate() {
        return DownloadRate;
    }

    public void setDownloadRate(int downloadRate) {
        DownloadRate = downloadRate;
    }

//    public enum DownloadState {
//        READY(0),
//        PROGRESSING(2),
//        SUCCESS(1),
//        FAIL(-1);
//
//        private final int val;
//
//        DownloadState(int val) {
//            this.val = val;
//        }
//    }
}
