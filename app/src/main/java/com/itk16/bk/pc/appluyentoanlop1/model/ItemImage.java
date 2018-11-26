package com.itk16.bk.pc.appluyentoanlop1.model;

import android.widget.Adapter;

public class ItemImage  {
    private int mImageResource;
    private String mImageName;

    public ItemImage(int ImageResource, String Imagename) {
        this.mImageResource = ImageResource;
        this.mImageName = Imagename;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int ImageResource) {
        this.mImageResource = ImageResource;
    }

    public String getmImageName() {
        return mImageName;
    }

    public void setmImageName(String Imagename) {
        this.mImageName = Imagename;
    }
}
