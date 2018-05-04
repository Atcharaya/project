package com.example.asus.project.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 4/5/2561.
 */

public class LevelDao {
    @SerializedName("LvId")
    private String LvId;

    @SerializedName("LvCode")
    private String LvCode;

    @SerializedName("LvName")
    private String LvName;

    @SerializedName("LvStatus")
    private String LvStatus;

    public String getLvId() {
        return LvId;
    }

    public void setLvId(String lvId) {
        LvId = lvId;
    }

    public String getLvCode() {
        return LvCode;
    }

    public void setLvCode(String lvCode) {
        LvCode = lvCode;
    }

    public String getLvName() {
        return LvName;
    }

    public void setLvName(String lvName) {
        LvName = lvName;
    }

    public String getLvStatus() {
        return LvStatus;
    }

    public void setLvStatus(String lvStatus) {
        LvStatus = lvStatus;
    }
}
