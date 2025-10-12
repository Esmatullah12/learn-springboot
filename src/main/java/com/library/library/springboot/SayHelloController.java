package com.library.library.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class SayHelloController {

    private  AuthenticationService authenticationService;

    public SayHelloController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        StringBuffer sb = new StringBuffer();
        sb.append("<h1>Hello from Spring boot</h1>");
        return sb.toString();
    }

    @RequestMapping("/say-hello-html")
    public String sayHelloHtml(Model model) {
        model.addAttribute("message", "Hello from Thymeleaf");
        return "sayHello"; // matches sayHello.html
    }

    @GetMapping("/welcome")
    public String welcome(@RequestParam(defaultValue = "Guest") String name, @RequestParam(defaultValue = "AFG") String country,Model model){
        model.addAttribute("name",name);
        model.addAttribute("welcome ",name);
        model.addAttribute("country",country);
        return "welcome";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public  String welcome(@RequestParam String name, @RequestParam String password, ModelMap model){
       if(authenticationService.AuthenticationService(name,password)){
           model.put("name",name);
           model.put("password",password);
           return "welcome";
       }
       model.put("error","Invalid username or password");
       return "login";
    }
}
