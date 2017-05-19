package scott.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssoward on 5/18/17.
 */
public class MoveReport {
    Elevator e;
    List<ReportType> reportTypesList = new ArrayList<>();
    public MoveReport(Elevator elevator, List<ReportType> reportTypes){
        this.e = elevator;
        this.reportTypesList = reportTypes;
    }
}
