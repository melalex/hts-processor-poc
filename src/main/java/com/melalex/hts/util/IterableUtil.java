package com.melalex.hts.util;

public final class IterableUtil {

    public static <T> T first(Iterable<T> iterable) {
        return iterable.iterator().next();
    }
}
