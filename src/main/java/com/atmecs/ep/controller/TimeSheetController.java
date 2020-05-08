package com.atmecs.ep.controller;

import com.atmecs.ep.model.TimeSheet;
import com.atmecs.ep.service.TimeSheetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/timesheet")
public class TimeSheetController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    TimeSheetService timesheetService;

    public TimeSheetController(TimeSheetService tsFacade) {
        super();
        this.timesheetService = tsFacade;
    }

    @GetMapping
    public ResponseEntity<?> getAllTimeSheets(@RequestParam String email) {
        return new ResponseEntity<>(timesheetService.retrieveAllTimeSheets(email), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTimeSheet(@RequestBody @Valid TimeSheet sheet) {
        return new ResponseEntity<>(timesheetService.create(sheet), HttpStatus.OK);
    }

    @GetMapping("/process")
    public ResponseEntity<?> processTimeSheet(@RequestParam String email, @RequestParam Integer weekNumber) {
        LOG.info("Processing WeekNumber : {} timesheet for email id : {}", weekNumber, email);
        return new ResponseEntity<>(timesheetService.processTimeSheet(email, weekNumber), HttpStatus.OK);
    }

    @GetMapping("/processAll")
    public ResponseEntity<?> processAllTimeSheets(@RequestParam String email) {
        LOG.info("Processing all timesheets for email id : {}", email);
        return new ResponseEntity<>(timesheetService.processAllTimeSheets(email), HttpStatus.OK);
    }

    @GetMapping("/clear")
    public ResponseEntity<String> clearAllTimeSheets(@RequestParam String email) {
        LOG.info("Clearing all timesheets for email id : {}", email);
        timesheetService.deleteAll(email);
        return new ResponseEntity<>("Removed all timecards", HttpStatus.OK);
    }

}
