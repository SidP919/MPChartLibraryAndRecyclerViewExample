package com.example.tcstestapp01;

public class DashboardMenu {

    private int mMenuImage;
    private String mMenuName;

    public DashboardMenu(int mMenuImage, String mMenuName) {
        this.mMenuImage = mMenuImage;
        this.mMenuName = mMenuName;
    }

    public int getmMenuImage() {
        return mMenuImage;
    }

    public String getmMenuName() {
        return mMenuName;
    }

    public void setmMenuImage(int mMenuImage) {
        this.mMenuImage = mMenuImage;
    }

    public void setmMenuName(String mMenuName) {
        this.mMenuName = mMenuName;
    }
}
