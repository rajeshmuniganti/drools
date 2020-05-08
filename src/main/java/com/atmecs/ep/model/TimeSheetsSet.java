package com.atmecs.ep.model;

import java.util.HashSet;
import java.util.Set;

public class TimeSheetsSet {

    private Set<TimeSheet> setOfTimeSheets;

    public TimeSheetsSet(Set<TimeSheet> setOfTimeSheets) {
        super();
        this.setOfTimeSheets = setOfTimeSheets;
    }

    public Set<TimeSheet> getSetOfTimeSheets() {
        return setOfTimeSheets;
    }

    public void setSetOfTimeSheets(Set<TimeSheet> setOfTimeSheets) {
        this.setOfTimeSheets = setOfTimeSheets;
    }

    public void addMovie(TimeSheet sheet) {
        if (setOfTimeSheets == null) {
            setOfTimeSheets = new HashSet<TimeSheet>();
        }
        setOfTimeSheets.add(sheet);
    }
}
