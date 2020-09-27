package com.melalex.hts.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface HtsMessage {

    byte key();

    Delimiter delimiter() default Delimiter.FE_FE;

    enum Delimiter {
        FE_FE,
        FD_FD
    }
}
