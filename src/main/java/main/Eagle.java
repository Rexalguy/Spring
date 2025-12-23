package main;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//We attempt to use the stereotype annotation

@Component
public class Eagle {
    private String name;

    @PostConstruct
    public void innit(){
        this.name = "Monroe";
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
