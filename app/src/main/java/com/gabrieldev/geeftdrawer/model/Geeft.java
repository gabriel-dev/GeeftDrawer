package com.gabrieldev.geeftdrawer.model;


import android.content.Context;

/**
 * Created by oldboy on 08/01/16.
 */
public class Geeft {

    private String mName;
    private String mGeefter;

    public String getName() {
        return mName;
    }

    public String getGeefter() {
        return mGeefter;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setGeefter(String geefter) {
        mGeefter = geefter;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public void setImageName(String imageName) {
        mImageName = imageName;
    }

    public String getImageName() {
        return mImageName;

    }

    private String mDescription;
    private String mImageName;


    public int getImageResourceId(Context context)
    {
        try {
            return context.getResources().getIdentifier(this.mImageName, "drawable", context.getPackageName());

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
