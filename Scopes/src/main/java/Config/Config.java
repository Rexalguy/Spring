package Config;

import Coffes.Coffee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Coffee coffee(){
        Coffee c = new Coffee();
        return c;
    }
}
