package com.melalex.hts.annotation;

public @interface HtsField {

    int offset() default -1;

    int size();
}
