package com.example.demo.annotation;

import com.example.demo.component.AbstractHandler;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectMap {
    Class<? extends AbstractHandler>[] value();
}
