package com.atmecs.ep.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Timesheet")
public class TimeSheet extends AbstractBaseEntity {

    private static final long serialVersionUID = -9149804971242373976L;
    @Column(nullable = false)
    private String email;

    @Column(name = "weekly_hours")
    private float weeklyHours;

    @Column(name = "week_number")
    private Integer weekNumber;

    @JsonIgnore
    @Column(name = "extra_time_burned")
    private Boolean extraTimeBurned;

    @JsonIgnore
    @Column(name = "additional_hours")
    private float additionalHours;

    @Column(name = "pay_rate_per_day")
    private float payRatePerDay;

    @Column(name = "pay_rate_per_ot")
    private float payRatePerOT;

    @Column(name = "total_pay")
    private float totalPay;

    @Column(name = "pay_status")
    private String payStatus;

    public TimeSheet() {
        super();
    }

    public TimeSheet(String email, float weeklyHours, Integer weekNumber, Boolean extraTimeBurned,
                     float additionalHours, float payRatePerDay, float payRatePerOT, float totalPay,
                     String payStatus) {
        super();
        this.email = email;
        this.weeklyHours = weeklyHours;
        this.weekNumber = weekNumber;
        this.extraTimeBurned = extraTimeBurned;
        this.additionalHours = additionalHours;
        this.payRatePerDay = payRatePerDay;
        this.payRatePerOT = payRatePerOT;
        this.totalPay = totalPay;
        this.payStatus = payStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(float weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    public Integer getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    public Boolean getExtraTimeBurned() {
        return extraTimeBurned;
    }

    public void setExtraTimeBurned(Boolean extraTimeBurned) {
        this.extraTimeBurned = extraTimeBurned;
    }

    public float getAdditionalHours() {
        return additionalHours;
    }

    public void setAdditionalHours(float additionalHours) {
        this.additionalHours = additionalHours;
    }

    public float getPayRatePerDay() {
        return payRatePerDay;
    }

    public void setPayRatePerDay(float payRatePerDay) {
        this.payRatePerDay = payRatePerDay;
    }

    public float getPayRatePerOT() {
        return payRatePerOT;
    }

    public void setPayRatePerOT(float payRatePerOT) {
        this.payRatePerOT = payRatePerOT;
    }

    public float getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(float totalPay) {
        this.totalPay = totalPay;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TimeSheet [email=");
        builder.append(email);
        builder.append(", weeklyHours=");
        builder.append(weeklyHours);
        builder.append(", weekNumber=");
        builder.append(weekNumber);
        builder.append(", extraTimeBurned=");
        builder.append(extraTimeBurned);
        builder.append(", additionalHours=");
        builder.append(additionalHours);
        builder.append(", budgetOverhead=");
        builder.append(", payRatePerDay=");
        builder.append(payRatePerDay);
        builder.append(", payRatePerOT=");
        builder.append(payRatePerOT);
        builder.append(", totalPay=");
        builder.append(totalPay);
        builder.append(", payStatus=");
        builder.append(payStatus);
        builder.append("]");
        return builder.toString();
    }
}
