package com.atmecs.ep.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

public class TimeSheetListener {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @PrePersist
    public void TimeSheetPrePersist(TimeSheet timeSheet) {
        LOG.info("Listening TimeSheet Pre Persist email : {}, weeknumber : {} ", timeSheet.getEmail(),
                timeSheet.getWeeklyHours());
    }

    @PostPersist
    public void TimeSheetPostPersist(TimeSheet timeSheet) {
        LOG.info("Listening TimeSheet Post Persist email : {}, weeknumber : {} ", timeSheet.getEmail(),
                timeSheet.getWeeklyHours());
    }

    @PostLoad
    public void TimeSheetPostLoad(TimeSheet timeSheet) {
        LOG.info("Listening TimeSheet Post Load email : {}, weeknumber : {} ", timeSheet.getEmail(),
                timeSheet.getWeeklyHours());
    }

    @PreUpdate
    public void TimeSheetPreUpdate(TimeSheet timeSheet) {
        LOG.info("Listening TimeSheet Pre Update email : {}, weeknumber : {} ", timeSheet.getEmail(),
                timeSheet.getWeeklyHours());
    }

    @PostUpdate
    public void TimeSheetPostUpdate(TimeSheet timeSheet) {
        LOG.info("Listening TimeSheet Post Update email : {}, weeknumber : {} ", timeSheet.getEmail(),
                timeSheet.getWeeklyHours());
    }

    @PreRemove
    public void TimeSheetPreRemove(TimeSheet timeSheet) {
        LOG.info("Listening TimeSheet Pre Remove email : {}, weeknumber : {} ", timeSheet.getEmail(),
                timeSheet.getWeeklyHours());
    }

    @PostRemove
    public void TimeSheetPostRemove(TimeSheet timeSheet) {
        LOG.info("Listening TimeSheet Post Remove email : {}, weeknumber : {} ", timeSheet.getEmail(),
                timeSheet.getWeeklyHours());
    }
}
