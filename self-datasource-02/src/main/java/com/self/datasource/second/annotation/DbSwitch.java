package com.self.datasource.second.annotation;

import com.self.datasource.second.enums.DbTypeEnum;

import java.lang.annotation.*;

/**
 * @see com.self.datasource.second.aspect.DbSwitchAspect
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DbSwitch {

    DbTypeEnum value() default DbTypeEnum.R;

}
