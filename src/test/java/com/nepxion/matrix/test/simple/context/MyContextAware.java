package com.nepxion.matrix.test.simple.context;

/**
 * <p>Title: Nepxion Matrix</p>
 * <p>Description: Nepxion Matrix AOP</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @email 1394997@qq.com
 * @version 1.0
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyContextAware implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private MyContextAware() {
    }

    private static void setContext(ApplicationContext applicationContext) {
        MyContextAware.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        MyContextAware.setContext(applicationContext);
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    public static String getProperty(String key) {
        return applicationContext.getEnvironment().getProperty(key);
    }

    public static boolean isProfileActive(String profile) {
        return applicationContext.getEnvironment().acceptsProfiles(profile);
    }
}