package com.course.coursedesign2022.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

//实体类
public class PointObject {
    private Integer id;
    //成长积分数
    private Integer growScore;
    //可兑换积分数
    private Integer exchangeScore;
    //总积分数
    private Integer scoreTotal;
    //登录日期
    private String lastLoginDate;
    //是否填写过个人资料
    private Boolean fillInformationBefore = false;  //默认未填写过
    //血糖记录次数
    private Integer bloodSugarCount = 0;  //默认0次
    //并发症填写日期
    private String bfzDate;
    //监测胰岛功能的日期
    private String ydgnDate;
    //设置日期格式
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public PointObject() {
    }

    public PointObject(Integer id, Integer growScore, Integer exchangeScore, Integer scoreTotal) {
        this.id = id;
        this.growScore = growScore;
        this.exchangeScore = exchangeScore;
        this.scoreTotal = scoreTotal;
    }

    public Integer getId() {
        return id;
    }

    public Integer getGrowScore() {
        return growScore;
    }

    public Integer getExchangeScore() {
        return exchangeScore;
    }

    public Integer getScoreTotal() {
        return scoreTotal;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGrowScore(Integer growScore) {
        this.growScore = growScore;
    }

    public void setExchangeScore(Integer exchangeScore) {
        this.exchangeScore = exchangeScore;
    }

    public void setScoreTotal(Integer scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public String getLastLoginDate() { return lastLoginDate; }

    public void setLastLoginDate(String date) { this.lastLoginDate = date; }

    public Boolean getFillInformationBefore() { return fillInformationBefore; }

    public void setFillInformationBefore(Boolean fillInformationBefore) { this.fillInformationBefore = fillInformationBefore; }

    //关于血糖次数的get/set方法
    public Integer getBloodSugarCount() { return bloodSugarCount; }

    public void setBloodSugarCount(Integer bloodSugarCount) { this.bloodSugarCount = bloodSugarCount; }

    public String getBfzDate() { return bfzDate; }

    public void setBfzDate(String date) { this.bfzDate = date; }
    //关于监测胰岛功能的get / set方法
    public String getydgnDate() { return ydgnDate; }

    public void setydgnDate(String date) { this.ydgnDate = date; }

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
        return "PointObject{" +
                "id=" + id +
                ", growScore=" + growScore +
                ", exchangeScore=" + exchangeScore +
                ", scoreTotal=" + scoreTotal +
                ", lastLoginDate=" + lastLoginDate +
                ", fillInformationBefore=" + fillInformationBefore +
                ", bloodSugarCount=" + bloodSugarCount +
                ", bfzDate=" + bfzDate +
                ", ydgnDate=" + ydgnDate +
                '}';
    }

}
