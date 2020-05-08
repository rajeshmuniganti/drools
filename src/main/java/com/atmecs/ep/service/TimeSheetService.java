package com.atmecs.ep.service;

import com.atmecs.ep.model.TimeSheet;
import com.atmecs.ep.repository.EPOperations;

import javax.validation.constraints.NotNull;
import java.util.Set;

public interface TimeSheetService extends EPOperations<TimeSheet> {

    public Integer processTimeSheet(String email, Integer weekNumber);

    public Integer processAllTimeSheets(String email);

    Set<TimeSheet> retrieveAllTimeSheets(@NotNull String email);

    public void deleteAll(String email);

}
