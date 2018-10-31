package com.codeup.springblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping(path = "/add/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int x, @PathVariable int y) {
        Integer sum = x + y;
        return sum.toString();
    }

    @RequestMapping(path = "/subtract/{x}/from/{y}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int x, @PathVariable int y) {
        Integer sub = y - x;
        return sub.toString();
    }

    @RequestMapping(path = "/multiply/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int x, @PathVariable int y) {
        Integer mult = x * y;
        return mult.toString();
    }

    @RequestMapping(path = "/divide/{x}/by/{y}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int x, @PathVariable int y){
        Integer div = x / y;
        return div.toString();
    }


}
