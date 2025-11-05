package com.course.coursedesign2022.pojo;

public class userInfo {
    private Integer id;

    private Integer growscore;

    private Integer exchangescore;

    private Integer scoretotal;

    private String lastlogindate;

    private Integer fillinformationbefore;

    private Integer bloodsugarcount;

    private String bfzdate;

    private String ydgndate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrowscore() {
        return growscore;
    }

    public void setGrowscore(Integer growscore) {
        this.growscore = growscore;
    }

    public Integer getExchangescore() {
        return exchangescore;
    }

    public void setExchangescore(Integer exchangescore) {
        this.exchangescore = exchangescore;
    }

    public Integer getScoretotal() {
        return scoretotal;
    }

    public void setScoretotal(Integer scoretotal) {
        this.scoretotal = scoretotal;
    }

    public String getLastlogindate() {
        return lastlogindate;
    }

    public void setLastlogindate(String lastlogindate) {
        this.lastlogindate = lastlogindate == null ? null : lastlogindate.trim();
    }

    public Integer getFillinformationbefore() {
        return fillinformationbefore;
    }

    public void setFillinformationbefore(Integer fillinformationbefore) {
        this.fillinformationbefore = fillinformationbefore;
    }

    public Integer getBloodsugarcount() {
        return bloodsugarcount;
    }

    public void setBloodsugarcount(Integer bloodsugarcount) {
        this.bloodsugarcount = bloodsugarcount;
    }

    public String getBfzdate() {
        return bfzdate;
    }

    public void setBfzdate(String bfzdate) {
        this.bfzdate = bfzdate == null ? null : bfzdate.trim();
    }

    public String getYdgndate() {
        return ydgndate;
    }

    public void setYdgndate(String ydgndate) {
        this.ydgndate = ydgndate == null ? null : ydgndate.trim();
    }
}