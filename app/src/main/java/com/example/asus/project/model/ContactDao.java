package com.example.asus.project.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 4/5/2561.
 */

public class ContactDao {
    @SerializedName("CttId")
    private String CttId;

    @SerializedName("CttName")
    private String CttName;

    @SerializedName("CttStatus")
    private String CttStatus;

    public String getCttId() {
        return CttId;
    }

    public void setCttId(String cttId) {
        CttId = cttId;
    }

    public String getCttName() {
        return CttName;
    }

    public void setCttName(String cttName) {
        CttName = cttName;
    }

    public String getCttStatus() {
        return CttStatus;
    }

    public void setCttStatus(String cttStatus) {
        CttStatus = cttStatus;
    }
}
