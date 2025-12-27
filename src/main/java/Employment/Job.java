package Employment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//This will illustrate a circular dependency

@Component
public class Job {
    private String name = "Java Developer";

    private final Employee employee;

    @Autowired
    public Job(Employee employee){
        this.employee = employee;
    }
}
