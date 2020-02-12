package io.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

  @RequestMapping("/form")
  public String form() {
    return "form";
  }

  @RequestMapping("/process-form")
  public String processForm() {
    return "process-form";
  }

  @RequestMapping("/process-form-upper-case")
  public String processFormUpperCase(HttpServletRequest request, Model model) {
    String name = request.getParameter("name");
    String nameMessage = String.format("Hello %s!!", name.toUpperCase());

    model.addAttribute("nameMessage", nameMessage);

    return "process-form-upper-case";
  }


  @RequestMapping("/process-form-request-param")
  public String processFormRequestParam(@RequestParam("name") String name, Model model) {
    String nameMessage = String.format("Using @RequestParam: %s!!", name.toUpperCase());

    model.addAttribute("nameMessage", nameMessage);

    return "process-form-upper-case";
  }

}
