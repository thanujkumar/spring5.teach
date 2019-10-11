package org.tk.spring.wiring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//https://www.baeldung.com/spring-component-scanning

@Configuration
@ComponentScan //No argument, so scan current package and all sub-packages (package where @Configuration class exists)
//@ComponentScan(basePackages = {"org.tk.spring.wiring"})
public class JavaWiringConfig {
}
