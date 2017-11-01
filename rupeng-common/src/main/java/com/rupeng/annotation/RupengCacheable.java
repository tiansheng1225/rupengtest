package com.rupeng.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//此注解是缓存的类级别的开关，标注了此注解的类的方法可以支持注解操作
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RupengCacheable {

    int expire() default 60;//缓存过期时间，单位是秒
}
