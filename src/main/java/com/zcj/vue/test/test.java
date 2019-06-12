package com.zcj.vue.test;

import java.io.File;
import java.io.IOException;

public class test {


    public static void main(String[] args) {
//        filedigui("D:\\d");
        filedigui("E:\\");
//        打开windows任意exe程序
//        try {
//            Runtime.getRuntime().exec("E:\\ThunderX\\Program\\Thunder.exe");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    /**
     * 递归遍历所有文件夹
     */
    public static void filedigui(String file) {
        File[] files = new File(file).listFiles();
        if (files != null) {
            for (File file2 : files) {
                System.out.println(file2.getName());
                filedigui(file2.getPath());
            }
        }
    }
}
