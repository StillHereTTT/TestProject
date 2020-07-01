package com.stillhere.interfaceIml;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by DJ026743 on 2020/7/1.
 */
@Retention(RUNTIME)
@Target({FIELD})
public @interface testSortInterface {

    int sort();
}
