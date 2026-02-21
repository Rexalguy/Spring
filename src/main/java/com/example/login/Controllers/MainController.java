package com.example.login.Controllers;

import com.example.login.Services.LoggedUserManagement;
import com.example.login.Services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    //Injection of the Login processor
    private final LoginProcessor loginProcessor;

    //Injection of logged user management
    private final LoggedUserManagement loggedUserManagement;

    //Injection for the Login count
    private LoginCountService loginCountService;

    public MainController(LoginProcessor loginProcessor, LoggedUserManagement loggedUserManagement, LoginCountService loginCountService){
        this.loginProcessor = loginProcessor;
        this.loggedUserManagement = loggedUserManagement;
        this.loginCountService = loginCountService;
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
            model.addAttribute("message", "You are now logged in");
            return "redirect:/main";
        }
        else{
            model.addAttribute("message","Login failed");
        }

        return "login.html";
    }

    @GetMapping("/main")
    public String home(
            @RequestParam(required = false) String logout,
            Model model
    ){
        //If the logout parameter has a value, we erase the username
        if (logout != null){
            loggedUserManagement.setUsername(null);
        }

        String username = loggedUserManagement.getUsername();
        int count = loginCountService.getCount();

        if(username == null){
            return "redirect:/";
        }
        else{
            model.addAttribute("username",username);
            model.addAttribute("loginCount", count);
            return "main.html";
        }
    }
}
