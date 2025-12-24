package Employment;

import org.springframework.stereotype.Component;

@Component
public class Manager {
    private final String name = "Mr.Kanu";

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Manger: "+ name;
    }
}
