package com.self.datasource.second.aspect;

import com.self.datasource.second.annotation.DbSwitch;
import com.self.datasource.second.config.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
public class DbSwitchAspect {

    /**
     * 注解@annotation只用于方法
     * 在within里加入注解可以使得在类上加注解也能走切面
     */
    @Pointcut("within(com.self.datasource.second.service.*) " +
            "&& @annotation(com.self.datasource.second.annotation.DbSwitch)" +
            "|| @within(com.self.datasource.second.annotation.DbSwitch)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 获取类上的注解
        Class<?> targetClass = pjp.getTarget().getClass();
        DbSwitch dbSwitch = targetClass.getDeclaredAnnotation(DbSwitch.class);
        if (dbSwitch != null) {
            return switchDbProceed(pjp, dbSwitch);
        }
        // 获取方法签名
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        // 获取方法对象
        Method method = signature.getMethod();
        // 获取方法上的注解
        dbSwitch = method.getDeclaredAnnotation(DbSwitch.class);
        if (dbSwitch == null) {
            return pjp.proceed();
        }
        return switchDbProceed(pjp, dbSwitch);
    }

    private Object switchDbProceed(ProceedingJoinPoint pjp, DbSwitch dbSwitch) throws Throwable {
        // 执行原方法
        DynamicDataSource.setCurrentDataSource(dbSwitch.value());
        try {
            return pjp.proceed();
        } finally {
            DynamicDataSource.clearCurrentDataSource();
        }
    }

}
