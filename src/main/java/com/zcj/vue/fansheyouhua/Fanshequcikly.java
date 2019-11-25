package com.zcj.vue.fansheyouhua;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对反射进行优化的方法
 * 具体思路就是，在第一次反射一个方法的时候，将他放入一个sourceMap中，
 * sourceMap是一个嵌套map，第一层key为反射类类名，第二层为反射类的<方法名，方法实体>
 * 在第一次创建后塞入map，在之后的反射过程中，直接去map中拿method对象，省去了创建内存和寻址的时间
 */
public class Fanshequcikly {


    private static Map<String, Map<String, Method>> sourceMap;

    static {
        sourceMap = new HashMap<>();
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        List entiylist = new ArrayList();
        int i = 0;
        //创建100万对象
        while (i < 1000000) {
            entiylist.add(fanshe2.class.newInstance());
            entiylist.add(fanshe1.class.newInstance());
            entiylist.add(fanshe3.class.newInstance());
            entiylist.add(fanshe4.class.newInstance());
            entiylist.add(fanshe.class.newInstance());
            i++;
        }
        entiylist.add(fanshe2.class.newInstance());

        entiylist.add(new fanshe());

        Fanshequcikly.quickly(entiylist);
        Fanshequcikly.quickly(entiylist);


        long startTime = System.currentTimeMillis();   //获取开始时间
        Fanshequcikly.quickly(entiylist);
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");

        long startTime1 = System.currentTimeMillis();   //获取开始时间
        Fanshequcikly.shouldslow(entiylist);
        long endTime1 = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime1 - startTime1) + "ms");

    }

    /**
     * 通过map所以调用反射方法
     *
     * @param entiylist
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void quickly(List entiylist) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        for (Object o : entiylist) {
            Class<?> aClass = o.getClass();
            if (sourceMap.get(aClass.getName()) == null) {
                sourceMap.put(aClass.getName(), new HashMap<>());
            }
            Map<String, Method> stringMethodMap = sourceMap.get(aClass.getName());
            if (sourceMap.get(aClass.getName()).get("getSuiyi") == null) {
                Method getSuiyi = aClass.getMethod("getSuiyi");
                stringMethodMap.put(getSuiyi.getName(), getSuiyi);
            }
            Object o1 = aClass.newInstance();
            stringMethodMap.get("getSuiyi").invoke(o1);
        }


    }

    /**
     * 没有索引根据反射创建方法
     *
     * @param entiylist
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void shouldslow(List entiylist) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        for (Object o : entiylist) {
            Class<?> aClass = o.getClass();
            Object o1 = aClass.newInstance();
            Method getSuiyi1 = aClass.getMethod("getSuiyi");
            getSuiyi1.invoke(o1);
        }
    }

}
