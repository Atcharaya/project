package com.example.asus.project.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by PREDATOR on 21/5/2561.
 */

public class SiteDao {
    @SerializedName("site_id")
    private String site_id;

    @SerializedName("site_name")
    private String site_name;

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }
}
