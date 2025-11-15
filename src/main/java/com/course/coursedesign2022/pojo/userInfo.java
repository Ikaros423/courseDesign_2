package com.course.coursedesign2022.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class userInfo {
    private Integer id;
    //成长积分数
    private Integer growscore=0;
    //可兑换积分数
    private Integer exchangescore=0;
    //总积分数
    private Integer scoretotal=0;
    //上次登录日期
    private String lastlogindate;
    //是否填写过个人资料，默认未填写
    private Integer fillinformationbefore = 0;
    //血糖记录次数，默认0次
    private Integer bloodsugarcount = 0;
    //并发症填写日期
    private String bfzdate;
    //监测胰岛功能的日期
    private String ydgndate;
    //设置日期格式
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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

    //计算两个日期之间相差的月份数
    public static long calculateMonths(String date1, String date2) {
        // 将字符串解析为LocalDate对象
        LocalDate startDate = LocalDate.parse(date1, formatter);
        LocalDate endDate = LocalDate.parse(date2, formatter);

        // 通过ChronoUnit计算相差的月份
        return ChronoUnit.MONTHS.between(startDate, endDate);
    }

    @Override
    public String toString() {
        return "userInfo{" +
                "id=" + id +
                ", growScore=" + growscore +
                ", exchangeScore=" + exchangescore +
                ", scoreTotal=" + scoretotal +
                ", lastLoginDate=" + lastlogindate +
                ", fillInformationBefore=" + fillinformationbefore +
                ", bloodSugarCount=" + bloodsugarcount +
                ", bfzDate=" + bfzdate +
                ", ydgnDate=" + ydgndate +
                '}';
    }
}