package com.example.asus.project.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by computer on 3/5/2561.
 */

public class ProjectDao {
    @SerializedName("SchName")
    private String SchName;

    @SerializedName("SchId")
    private String SchId;

    @SerializedName("SchStatus")
    private String SchStatus;

    public String getSchName() {
        return SchName;
    }

    public void setSchName(String schName) {
        SchName = schName;
    }

    public String getSchId() {
        return SchId;
    }

    public void setSchId(String schId) {
        SchId = schId;
    }

    public String getSchStatus() {
        return SchStatus;
    }

    public void setSchStatus(String schStatus) {
        SchStatus = schStatus;
    }
}
