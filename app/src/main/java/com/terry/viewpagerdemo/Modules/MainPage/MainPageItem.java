package com.terry.viewpagerdemo.Modules.MainPage;

public class MainPageItem {
    private int Icon;
    private String Name;
    private String Description;
    private String Tip;
    private boolean isOld;

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTip() {
        return Tip;
    }

    public void setTip(String tip) {
        Tip = tip;
    }

    public boolean isOld() {
        return isOld;
    }

    public void setOld(boolean isOld) {
        this.isOld = isOld;
    }

    @Override
    public String toString() {
        return String.format("title:%s: isold %s ", getName(), isOld);
    }
}
