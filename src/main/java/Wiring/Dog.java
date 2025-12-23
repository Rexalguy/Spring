package Wiring;

public class Dog {
    private String name;

    //No arg constructor to test how many dog instances are created
    public Dog (){
        System.out.println("Dog has been created");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog: "+ name;
    }
}
