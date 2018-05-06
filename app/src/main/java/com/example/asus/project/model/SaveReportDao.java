package com.example.asus.project.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pongsapat on 06-May-18.
 */

public class SaveReportDao {
    @SerializedName("rq_id")
    private String rqId;

    public String getRqId() {
        return rqId;
    }

    public void setRqId(String rqId) {
        this.rqId = rqId;
    }

    public String getRqDate() {
        return rqDate;
    }

    public void setRqDate(String rqDate) {
        this.rqDate = rqDate;
    }

    public String getRqSubject() {
        return rqSubject;
    }

    public void setRqSubject(String rqSubject) {
        this.rqSubject = rqSubject;
    }

    public String getSysName() {
        return sysName;
    }

    public void setRqDetail(String rqDetail) {
        this.sysName = rqDetail;
    }

    @SerializedName("rq_date")
    private String rqDate;

    @SerializedName("rq_subject")
    private String rqSubject;

    @SerializedName("sys_name")
    private String sysName;


}
