package com.terry.viewpagerdemo.Modules.MainPage;

public class MainPageItem {
    private int Icon;
    private String Name;
    private String Description;

    public MainPageItem(int icon, String name, String description) {
        Icon = icon;
        Name = name;
        Description = description;
    }

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
}
