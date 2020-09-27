package com.melalex.hts.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface HtsMessage {

    byte key();

    byte type();

    Delimiter delimiter() default Delimiter.FE_FE;

    enum Delimiter {
        FE_FE(new int[]{0xFE, 0xFE}),
        FD_FD(new int[]{0xFD, 0xFED});

        private final byte[] value;

        Delimiter(int[] value) {
            this.value = new byte[]{
                    (byte) value[0],
                    (byte) value[1]
            };
        }

        public byte[] getValue() {
            return value;
        }
    }
}
