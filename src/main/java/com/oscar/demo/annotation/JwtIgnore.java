package com.oscar.demo.annotation;

import java.lang.annotation.*;

/**
 * 功能描述: JWT验证忽略注解
 * @Author: oscar
 * @Date: 2020/8/13 18:15
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtIgnore {
}
