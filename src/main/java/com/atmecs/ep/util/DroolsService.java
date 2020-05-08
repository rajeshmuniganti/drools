package com.atmecs.ep.util;

import com.atmecs.ep.model.TimeSheet;
import com.atmecs.ep.model.TimeSheetsSet;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DroolsService {

    private final KieContainer kieContainer;

    @Autowired
    public DroolsService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    /**
     * This method will be invoked while adding a time sheet. This is supposed
     * to fire rules which are defined in timesheetrules.drl
     *
     * @param sheet
     * @return
     */
    // TODO: Remove redundent code
    public TimeSheet addTimeSheet(TimeSheet sheet) {
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.insert(sheet);

        // @formatter:off
		/*kieSession.fireAllRules(new AgendaFilter() {
			@Override
			public boolean accept(Match match) {
				if (("timesheet.rules".equals(match.getRule().getPackageName()))) {
					return true;
				}
				return false;
			}
		});*/
        // @formatter:on

        kieSession.fireAllRules();
        kieSession.dispose();
        return sheet;
    }

    // TODO: Remove redundent code

    /**
     * This method will be invoked while processing a time sheet. This is
     * supposed to fire rules which are defined in process_timesheet.drl
     *
     * @param sheet
     * @return
     */
    public TimeSheet processTimeSheet(TimeSheet sheet) {
        KieSession kieSession = kieContainer.newKieSession("processrules");
        kieSession.insert(sheet);
        kieSession.fireAllRules();
        kieSession.dispose();
        return sheet;
    }

    // TODO: Remove redundent code

    /**
     * This method will be invoked while processing a time sheet. This is
     * supposed to fire rules which are defined in process_timesheet.drl
     *
     * @param timeSheetsSet
     * @return
     */
    public Set<TimeSheet> processAllTimeSheets(TimeSheetsSet timeSheetsSet) {
        KieSession kieSession = kieContainer.newKieSession("processrules");
        kieSession.insert(timeSheetsSet);
        kieSession.fireAllRules();
        kieSession.dispose();
        return timeSheetsSet.getSetOfTimeSheets();
    }
}