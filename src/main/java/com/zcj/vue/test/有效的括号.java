package com.zcj.vue.test;

import java.util.Arrays;

public class 有效的括号 {

    public static void main(String[] args) {
//        teststring("()[]{}");
        System.out.println(kk("(([]){})"));
    }


    public static boolean teststring(String s) {
        s = s.replaceAll(" ", "");
        int i = s.length() % 2;
        if (i > 0) {
            return false;
        }
        String[] split = s.split("");

        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, error = 0;
        String last = "";
        for (int j = 0; j < split.length; j++) {
            switch (split[j]) {
                case "{":
                    a++;
                    if (j == 0) {
                        last = "}";
                    }
                    break;
                case "}":
                    b++;
                    break;
                case "[":
                    c++;
                    if (j == 0) {
                        last = "]";
                    }
                    break;
                case "]":
                    d++;
                    break;
                case "(":
                    e++;
                    if (j == 0) {
                        last = ")";
                    }
                    break;
                case ")":
                    f++;
                    break;
            }
        }
        if (a == b & c == d & e == f && last.equals(split[split.length - 1])) {
            System.out.println("哇哈哈");
            return true;
        }

        return false;
    }


    public static boolean kk(String s) {
        s = s.replaceAll(" ", "");
        int i = s.length() % 2;
        if (i > 0) {
            return false;
        }
        String[] split = s.split("");

        int[] arr = new int[s.length()];
        int a = 1, b = 2, c = 3, error = 0;
        String a3 = "(";
        String a4 = ")";
        String b3 = "[";
        String b4 = "]";
        String c3 = "{";
        String c4 = "}";
        String last = "";
        for (int j = 0; j < split.length; j++) {
            switch (split[j]) {
                case "{":
                    arr[j] = c;
                    break;
                case "}":
                    arr[j] = c;
                    break;
                case "[":
                    arr[j] = b;
                    break;
                case "]":
                    arr[j] = b;
                    break;
                case "(":
                    arr[j] = a;
                    break;
                case ")":
                    arr[j] = a;
                    break;
            }
        }
        if (split.length == 2 && arr[0] == arr[1] && !split[0].equals(split[1])) {
            System.out.println("不行");
            return true;
        }

        int jishunum = 0;
        int oushunum = 0;
        if (arr.length >= 4 && !split[0].equals(split[split.length - 1]) && arr[0] == arr[arr.length - 1]) {
//            for (int j = 0, k = 0; j < arr.length; j++, k += 2) {
////                if (j % 2 == 1) {
////                    System.out.println(arr[j]);
////                    oushunum += arr[j];
////                }
////                jishunum += arr[k];
////                if (oushunum != jishunum) {
////                    System.out.println("kkkk");
////                    return false;
////                }
//                if (j % 2 == 0 && j + 3 < arr.length) {
//                    oushunum += arr[j] + arr[j + 2];
//                    jishunum += arr[j + 1] + arr[j + 3];
//                }
//
//            }
//            if (jishunum == oushunum && !split[0].equals(split[split.length - 1])) {
//                System.out.println("行");
//                return true;
//            }
            System.out.println(Arrays.toString(arr));
            for (int k = 0, j = arr.length - 1; k < arr.length / 2; k++, j--) {
                if (arr[k] != arr[j]) {
                    error++;
                }
            }
            if (error > 0) {
                for (int k = 0; k < arr.length; k += 2) {
                    if (k % 2 == 0 && k < arr.length - 1) {
                        if (arr[k] != arr[k + 1]) {
                            return false;
                        }
                    }
                }
                return true;
            } else {
                return true;
            }
        }
        if (s.equals("")) {
            return true;
        }
        return false;
    }
}
