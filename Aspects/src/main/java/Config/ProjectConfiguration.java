package Config;

import Aspect.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"Services","Aspects"})
@EnableAspectJAutoProxy
public class ProjectConfiguration {

    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }

    }
