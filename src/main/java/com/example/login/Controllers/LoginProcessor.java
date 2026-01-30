package com.example.login.Controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private String username;
    private String password;

    public Boolean login(){
        String username = this.getUsername();
        String password = this.getPassword();

        //Login logic
        if ("Natalie".equals(username) && "password".equals(password)){
            return true;
        }
        else{
            return false;
        }
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
