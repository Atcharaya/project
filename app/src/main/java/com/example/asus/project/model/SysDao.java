package com.example.asus.project.model;

/**
 * Created by computer on 6/5/2561.
 */

public class SysDao  {
    private String SysId;
    private String SysName;
    private String SiteName;
    private String SchName;

    public String getSysId() {
        return SysId;
    }

    public void setSysId(String sysId) {
        SysId = sysId;
    }

    public String getSysName() {
        return SysName;
    }

    public void setSysName(String sysName) {
        SysName = sysName;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }

    public String getSchName() {
        return SchName;
    }

    public void setSchName(String schName) {
        SchName = schName;
    }
}
