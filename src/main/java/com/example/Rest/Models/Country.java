package com.example.Rest.Models;

public class Country {

    private String name;
    private int population;

    //We shall use a static factory for object creation
    public static Country of (String name, int population){
        Country country = new Country();
        country.setName(name);
        country.setPopulation(population);
        return country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
