package com.zcj.vue.test;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {


    public static void main(String[] args) {
//        filedigui("D:\\d");
//        filedigui("E:\\");
//        打开windows任意exe程序
//        try {
//            Runtime.getRuntime().exec("E:\\ThunderX\\Program\\Thunder.exe");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        isPalindrome(10101);
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

    //测试回文数
    static boolean isPalindrome(int x) {
        List<Integer> num = new ArrayList<>();
        int i = 1;
        if (x >= 0) {
            while (i > 0) {
                num.add(x % 10);
                x = x / 10;
                i = x;
            }
            int size = num.size() / 2;
            int downsize = size;
            int upwnsize = size;
            int up[] = new int[size];
            int down[] = new int[size];
            if (num.size() % 2 == 0) {
                for (int j = 0; j < size; j++) {
                    down[j] = num.get(downsize);
                    downsize++;
                    upwnsize--;
                    up[j] = num.get(upwnsize);
                }
            } else {
                for (int k = 0; k < size; k++) {
                    downsize++;
                    down[k] = num.get(downsize);
                    upwnsize--;
                    up[k] = num.get(upwnsize);
                }
            }
            return Arrays.equals(up, down);
        }
        return false;
    }

    //整数反转
    public int reverse(int x) {
        List<Integer> num = new ArrayList<>();
        int i = 1;
        if (x >= 0) {
            while (i > 0) {
                num.add(x % 10);
                x = x / 10;
                i = x;
            }
        }
        return x;
    }

}
