package Employment;

import org.springframework.stereotype.Component;

@Component
public class Ast_Manager {
    private  final String name = "Bill";

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Ast_Manager: " + name;
    }
}
