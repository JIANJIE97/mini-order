package fun.jianjie.miniorder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestHttpsController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
