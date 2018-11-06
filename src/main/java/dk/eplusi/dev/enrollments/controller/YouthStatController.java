package dk.eplusi.dev.enrollments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class YouthStatController {
    @GetMapping(value = "/youthStatSearch")
    public String youthStatSearch() {
        return "youthStat/youthStatSearch";
    }

    @GetMapping(value = "/youthStatAttendSearch")
    public String youthStatAttendSearch() {
        return "youthStat/youthStatAttendSearch";
    }

    @GetMapping(value = "/youthStatDetail")
    public String youthStatDetail() {
        return "youthStat/youthStatDetail";
    }
}
