package com.syriansoldier.big_event.utils;

public class ThreadLocalUtils {
    private static final ThreadLocal<Object> THREAD_LOCAL = new ThreadLocal<>();

    public static void set(Object value){
        THREAD_LOCAL.set(value);
    }

    public static <T> T get(){
        return (T)THREAD_LOCAL.get();
    }

    public static void remove(){
        THREAD_LOCAL.remove();
    }
}
