package com.zcj.vue.test;


import com.zcj.vue.springcode.sona;
import com.zcj.vue.springcode.sonb;
import com.zcj.vue.springcode.springIOP;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test extends Object {


    public static void main(String[] args) {
//        filedigui("D:\\d");
//        filedigui("E:\\");
//        打开windows任意exe程序
//        try {
//            Runtime.getRuntime().exec("E:\\ThunderX\\Program\\Thunder.exe");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        isPalindrome(10101);
//        System.out.println(reverse(-2147483648));
     springIOP springIOP=new springIOP(new sonb());
     springIOP.jklj();
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
    public static int reverse(int x) {
        List<Integer> num = new ArrayList<>();
        int i = 1;
        int shijinum = 0;
        int weishu = 1;
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE || x == 0) {
            return 0;
        }
        if (x > 0) {
            while (i > 0) {
                num.add(x % 10);
                x = x / 10;
                i = x;
            }
            if (num.get(0) == 0) {
                num.remove(0);
            }
            for (int nm = 0; nm < num.size() - 1; nm++) {
                weishu *= 10;
            }
            for (int uu = weishu, ll = 0, fanbi = num.size() - 1; uu >= 1; uu /= 10) {
                if (Integer.MAX_VALUE / uu % 10 < num.get(ll) && num.size() == 10) {
                    return 0;
                }
                shijinum += num.get(ll) * uu;
                ll++;
                fanbi--;
            }
            return shijinum;
        } else {
            x = -x;
            while (i > 0) {
                num.add(x % 10);
                x = x / 10;
                i = x;
            }
            if (num.get(0) == 0) {
                num.remove(0);
            }
            for (int nm = 0; nm < num.size() - 1; nm++) {
                weishu *= 10;
            }
            for (int uu = weishu, ll = 0; uu >= 1; uu /= 10) {
                if (num.size() == 10) {
                    try {
                        Math.addExact(shijinum, num.get(ll) * uu);
//                        Math.multiplyExact(-num.get(ll), uu);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return 0;
                    }
                }
                shijinum += num.get(ll) * uu;
                ll++;
            }
            return -shijinum;
        }
    }

}
