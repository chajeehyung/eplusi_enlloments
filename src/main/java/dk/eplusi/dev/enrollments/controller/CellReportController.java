package dk.eplusi.dev.enrollments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CellReportController {
    @GetMapping(value = "/cellReportSearch")
    public String cellReportSearch() {
        return "cellReport/cellReportSearch";
    }

    @GetMapping(value = "/cellReportInsert")
    public String cellReportInsert() {
        return "cellReport/cellReportInsert";
    }

    @GetMapping(value = "/cellReportModify")
    public String cellReportModify(){
        return "cellReport/cellReportModify";
    }
}
