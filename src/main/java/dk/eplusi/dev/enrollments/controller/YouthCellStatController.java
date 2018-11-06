package dk.eplusi.dev.enrollments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class YouthCellStatController {
    @GetMapping(value = "/youthCellStatSearch")
    public String youthCellStatSearch() {
        return "youthCellStat/youthCellStatSearch";
    }

    @GetMapping(value = "/youthCellStatDetail")
    public String youthCellStatDetail() {
        return "youthCellStat/youthCellStatDetail";
    }
}
