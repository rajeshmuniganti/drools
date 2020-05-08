package com.atmecs.ep.service;

import com.atmecs.ep.model.TimeSheet;
import com.atmecs.ep.model.TimeSheetsSet;
import com.atmecs.ep.repository.AbstractEPOperations;
import com.atmecs.ep.repository.TimeSheetRepository;
import com.atmecs.ep.util.DroolsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(value = "transactionManager")
public class TimeSheetServiceImpl extends AbstractEPOperations<TimeSheet> implements TimeSheetService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    DroolsService droolsService;
    @Autowired
    private TimeSheetRepository timeSheetDao;

    public TimeSheetServiceImpl() {
        super();
    }

    @Override
    public Set<TimeSheet> retrieveAllTimeSheets(@NotNull String email) {
        return timeSheetDao.findByemail(email);
    }

    @Override
    public TimeSheet create(TimeSheet timeSheet) {
        timeSheet = droolsService.addTimeSheet(timeSheet);
        return timeSheetDao.save(timeSheet);
    }

    @Override
    public Integer processTimeSheet(String email, Integer weekNumber) {
        // @formatter:off
        TimeSheet sheet = timeSheetDao.findByemail(email)
                .stream()
                .filter(v -> weekNumber == v.getWeekNumber())
                .findFirst()
                .get();
        // @formatter:on
        droolsService.processTimeSheet(sheet);
        LOG.info("Timesheet after rules are applied: {}", sheet.toString());
        return timeSheetDao.updateTimeSheet(sheet.getEmail(), sheet.getWeekNumber(), sheet.getPayStatus());
    }

    @Override
    public Integer processAllTimeSheets(String email) {

        // @formatter:off
        Set<TimeSheet> timeSheets = timeSheetDao.findByemail(email)
                .stream()
                .filter(v -> null == v.getPayStatus()).collect(Collectors.toSet());

        // @formatter:on

        TimeSheetsSet timeSheetsSet = new TimeSheetsSet(timeSheets);
        timeSheets = droolsService.processAllTimeSheets(timeSheetsSet);
        timeSheets.forEach(v -> {
            timeSheetDao.updateTimeSheet(v.getEmail(), v.getWeekNumber(), v.getPayStatus());
        });
        return timeSheets.size();
    }

    @Override
    protected CrudRepository<TimeSheet, Serializable> getDao() {
        return timeSheetDao;
    }

    @Override
    public void deleteAll(String email) {
        timeSheetDao.deleteAll();
    }

}
