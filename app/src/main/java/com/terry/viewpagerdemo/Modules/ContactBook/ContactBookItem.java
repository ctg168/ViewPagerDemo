package com.terry.viewpagerdemo.Modules.ContactBook;


public class ContactBookItem {
    private int ImgId;
    private int ContactGroup;
    private boolean IsFav;
    private String ObjectName;
    private String PhoneNumber;
    private int Sex;

    @Override
    public String toString() {
        return "尊敬的客户，您套餐内上网流量共150M，截止13日01时，已使用63.22M，剩余86.78M。仅供参考，具体以月结账单为准。您可直接回复33，即可查询与办理流量资费。中国移动";
    }

    public int getImgId() {
        return ImgId;
    }

    public void setImgId(int imgId) {
        ImgId = imgId;
    }

    public int getContactGroup() {
        return ContactGroup;
    }

    public void setContactGroup(int contactGroup) {
        ContactGroup = contactGroup;
    }

    public boolean isFav() {
        return IsFav;
    }

    public void setIsFav(boolean isFav) {
        IsFav = isFav;
    }

    public String getObjectName() {
        return ObjectName;
    }

    public void setObjectName(String objectName) {
        ObjectName = objectName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int sex) {
        Sex = sex;
    }
}
