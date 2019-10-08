package com.zcj.vue.lambda;

public interface test1 {
    String kk();

    int fff();

    String test1();

    default int add(int a , int b){
        return a+b;
    }
}
