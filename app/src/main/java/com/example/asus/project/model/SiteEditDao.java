package com.example.asus.project.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by PREDATOR on 21/5/2561.
 */

public class SiteEditDao {

    @SerializedName("rq_detail")
    private String rq_detail;

    @SerializedName("rq_date")
    private String rq_date;

    @SerializedName("sys_name")
    private String sys_name;

    @SerializedName("rq_id")
    private String rq_id;

    public String getRq_detail() {
        return rq_detail;
    }

    public void setRq_detail(String rq_detail) {
        this.rq_detail = rq_detail;
    }

    public String getRq_date() {return rq_date;}

    public void setRq_date(String rq_date) {
        this.rq_date = rq_date;
    }

    public String getSys_name() {
        return sys_name;
    }

    public void setSys_name(String sys_name) {
        this.sys_name = sys_name;
    }

    public String getRq_id() {return rq_id;}

    public void setRq_id(String rq_id) {this.rq_id = rq_id;}

}
