package com.example.handlingformsubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

  
  @GetMapping("/greeting")
  public String greetingForm(Model model) {
    model.addAttribute("greeting", new Greeting());
    return "greeting";
  }
  
  @PostMapping("/greeting")
  public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {

    String concatenatedString = greeting.getF1() + greeting.getF2() + greeting.getF3() + greeting.getF4() + greeting.getR1() + greeting.getR2() + greeting.getR3() + greeting.getR4() + greeting.getB1() + greeting.getB2() + greeting.getB3() + greeting.getB4() + greeting.getL1() + greeting.getL2() + greeting.getL3() + greeting.getL4() + greeting.getT1() + greeting.getT2() + greeting.getT3() + greeting.getT4() + greeting.getBo1() + greeting.getBo2() + greeting.getBo3() + greeting.getBo4();
    //String concatenatedString = greeting.getF1() + greeting.getF2() + greeting.getF3() + greeting.getF4() + greeting.getR1() + greeting.getR2() + greeting.getR3() + greeting.getR4();
    System.out.println(concatenatedString);
    solve object = new solve();
    String result = object.notmain(concatenatedString);
    //String result = object.notmain(c);
    model.addAttribute("result", result);
    //model.addAttribute("result", concatenatedString);
    return "result";
  }

  //THIS WORKED, leave as backup:
  // @PostMapping("/greeting")
  // public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
  //   String input = greeting.getContent();
  //   String resultOfInput = input;
  //   solve object = new solve();
  //   String result = object.notmain(resultOfInput);
  //   model.addAttribute("result", result);
  //   return "result";
  // }

}
