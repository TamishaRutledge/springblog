package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    @ResponseBody
    public String showDice(){
        return "Please guess a number </br><ul>" +
                "<li><a href='/roll-dice/1'>1</a></li>" +
                "<li><a href='/roll-dice/2'>2</a></li>" +
                "<li><a href='/roll-dice/3'>3</a></li>" +
                "<li><a href='/roll-dice/4'>4</a></li>" +
                "<li><a href='/roll-dice/5'>5</a></li>" +
                "<li><a href='/roll-dice/6'>6</a></li>" +
                "</ul>";

    }

    @GetMapping("/roll-dice/{n}")
    @ResponseBody
    public String checkGuess(@PathVariable Integer n){
        Integer dice = new Random().nextInt(6) + 1;
        String response = "<h2>The number was " + dice.toString() + "</h2>";
        if (n == dice)
            response += "<h3>You guessed correct!</h3>";
        else
            response += "<h3>Not today</h3>";
            response += "<a href='/roll-dice'>Try Again!</a>";
        return response;
    }


}


