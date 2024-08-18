package cn.youyou.sc.provider.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceRegisterAspect {

//    public final static String TYPE = "type";
    public final static String DC_KEY = "dc";
    public final static String ZONE_KEY = "zone";
    public final static String ENV_KEY = "env";
    public final static String GROUP_KEY = "group";

    @Autowired
    Environment environment;

    @Before("execution(* org.springframework.cloud.client.serviceregistry.ServiceRegistry.register(..))")
    public void beforeRegister(JoinPoint jp) {
        String dc    = environment.getProperty(DC_KEY, "BJ");
        String zone  = environment.getProperty(ZONE_KEY, "B001");
        String env   = environment.getProperty(ENV_KEY, "DEV");
        String group = environment.getProperty(GROUP_KEY, "DEFAULT");

        System.out.println("ServiceRegisterAspect.beforeRegister for dc/zone/env/group: "
                + dc + "/" + zone + "/" + env + "/" + group);

        Object[] args = jp.getArgs();
        for (Object o : args) {
            if (o instanceof Registration registration) {
                registration.getMetadata().put(DC_KEY, dc);
                registration.getMetadata().put(ZONE_KEY, zone);
                registration.getMetadata().put(ENV_KEY, env);
                registration.getMetadata().put(GROUP_KEY, group);
                System.out.println("ServiceRegisterAspect.beforeRegister for Registration.metaDate: " + registration.getMetadata());
            }
        }

    }

}
