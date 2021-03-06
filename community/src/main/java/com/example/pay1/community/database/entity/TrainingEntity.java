package com.example.pay1.community.database.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "feedData")
public class TrainingEntity {

    @PrimaryKey(autoGenerate = true)
    private int fid;

    @ColumnInfo(name="title")
    private String title;

    @ColumnInfo(name="titleUrl")
    private String titleUrl;

    @ColumnInfo(name = "iconUrl")
    private String iconUrl;

    @ColumnInfo(name = "type")
    private int type;

    @ColumnInfo(name = "timestamp")
    private String timestamp;

    public TrainingEntity(String tit, String titUrl, String icUrl, int typ, String tmstmp)
    {
        title=tit;
        titleUrl=titUrl;
        iconUrl=icUrl;
        type=typ;
        timestamp=tmstmp;
    }

    public TrainingEntity()
    {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleUrl() {
        return titleUrl;
    }

    public void setTitleUrl(String titleUrl) {
        this.titleUrl = titleUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }
}
