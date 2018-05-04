package com.example.asus.project.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 4/5/2561.
 */

public class CatagoryDao {
    @SerializedName("KnId")
    private String KnId;

    @SerializedName("KnName")
    private String KnName;

    @SerializedName("CtId")
    private String CtId;

    @SerializedName("CtName")
    private String CtName;

    @SerializedName("CtKnId")
    private String CtKnId;

    public String getKnId() {
        return KnId;
    }

    public void setKnId(String knId) {
        KnId = knId;
    }

    public String getKnName() {
        return KnName;
    }

    public void setKnName(String knName) {
        KnName = knName;
    }

    public String getCtId() {
        return CtId;
    }

    public void setCtId(String ctId) {
        CtId = ctId;
    }

    public String getCtName() {
        return CtName;
    }

    public void setCtName(String ctName) {
        CtName = ctName;
    }

    public String getCtKnId() {
        return CtKnId;
    }

    public void setCtKnId(String ctKnId) {
        CtKnId = ctKnId;
    }
}
