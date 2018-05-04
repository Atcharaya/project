package com.example.asus.project.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 4/5/2561.
 */

public class SystemDao {

    @SerializedName("TeamId")
    private String TeamId;

    @SerializedName("TeamName")
    private String TeamName;

    @SerializedName("TeamStatus")
    private String TeamStatus;

    public String getTeamId() {
        return TeamId;
    }

    public void setTeamId(String teamId) {
        TeamId = teamId;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String getTeamStatus() {
        return TeamStatus;
    }

    public void setTeamStatus(String teamStatus) {
        TeamStatus = teamStatus;
    }
}
