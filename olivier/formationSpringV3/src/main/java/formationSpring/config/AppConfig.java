package formationSpring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"formationSpring.bean","formationSpring.aspect"})
@EnableAspectJAutoProxy
public class AppConfig {

}
