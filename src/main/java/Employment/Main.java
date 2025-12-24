package Employment;

import config.EmploymentConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //We initialize the Spring context
        var context = new AnnotationConfigApplicationContext(EmploymentConfig.class);

        //We access the employee and their manager
        Employee emp = context.getBean(Employee.class);

        System.out.println("Employee name: " + emp.getName());
        System.out.println("Employee : " +emp.getManger());
        System.out.println("Assistant manager: " + emp.getAst_manger());
    }
}
