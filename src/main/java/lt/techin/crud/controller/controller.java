package lt.techin.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello!";
    }

    @RequestMapping("/hi")
    @ResponseBody
    public String hi() {
        return "Hi!";
    }

}
