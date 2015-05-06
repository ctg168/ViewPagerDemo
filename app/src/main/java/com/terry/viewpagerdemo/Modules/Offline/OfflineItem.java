package com.terry.viewpagerdemo.Modules.Offline;

public class OfflineItem {
    String Url;
    String StoreFileName;
    int DownloadRate;

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

    public int getDownloadRate() {
        return DownloadRate;
    }

    public void setDownloadRate(int downloadRate) {
        DownloadRate = downloadRate;
    }
}
