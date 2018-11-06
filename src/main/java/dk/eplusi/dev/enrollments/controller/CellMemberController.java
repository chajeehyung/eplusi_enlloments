package dk.eplusi.dev.enrollments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CellMemberController {
    @GetMapping(value = "/cellMemberStatus")
    public String cellMemberStatus() {
        return "cellMember/cellMemberStatus";
    }

    @GetMapping(value = "/cellMemberAttendSearch")
    public String cellMemberAttendStatus() {
        return "cellMember/cellMemberAttendSearch";
    }

    @GetMapping(value = "/cellMemberStatusDetail")
    public String cellMemberStatusDetail() {
        return "cellMember/cellMemberStatusDetail";
    }

    @GetMapping(value = "/cellMemberAttendInsert")
    public String cellMemberAttendInsert(){
        return "cellMember/cellMemberAttendInsert";
    }

    @GetMapping(value = "/cellMemberAttendIModify")
    public String cellMemberAttendIModify(){
        return "cellMember/cellMemberAttendIModify";
    }

}
