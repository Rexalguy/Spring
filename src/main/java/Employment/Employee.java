package Employment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    public String name = "Manuel";

    @Autowired
    private  Manager manager;

    //For the constructor injection
    private final Ast_Manager ast_manger;

    //For the circular dependency
//    private final Job job;

    @Autowired
    public Employee(Ast_Manager ast_manger){
        this.ast_manger = ast_manger;
//        this.job = job;
    }

    public String getName() {
        return name;
    }

    public Manager getManger() {
        return manager;
    }

    public Ast_Manager getAst_manger(){
        return this.ast_manger;
    }

//    public Job getJob() {
//        return job;
//    }
}
