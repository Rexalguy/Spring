package com.example.login.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    //Injection of the Login processor
    private final LoginProcessor loginProcessor;

    public MainController(LoginProcessor loginProcessor){
        this.loginProcessor = loginProcessor;
    }



    @GetMapping("/")
    public String getLogin(){
        return "login";
    }

    @PostMapping("/")
    public String postLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ){
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        boolean isLogged = loginProcessor.login();

        if (isLogged){
            model.addAttribute("message", "You are logged in");
        }
        else{
            model.addAttribute("message","Login failed");
        }

        return "login.html";
    }
}
