package com.bookstore;

public class SettingsClass {

    private String settingName, details;
    private boolean expandable;

    public SettingsClass(String settingName, String details) {
        this.settingName = settingName;
        this.details = details;
        this.expandable = false;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public String getSettingName() {
        return settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "SettingsClass{" +
                "settingName='" + settingName + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
