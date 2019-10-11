package org.tk.spring.beandefinition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfigBeanDef.class);
        for (String name : annotationConfigApplicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        //Single is lazy initialized, so until bean is accessed BeanPostProcessor not called, change by lazy-initialization mode
        AnotherMyBean anotherMyBean = annotationConfigApplicationContext.getBean("anotherMyBean", AnotherMyBean.class);
        System.out.println(anotherMyBean.getVersion());

        annotationConfigApplicationContext.registerShutdownHook();
    }
}
