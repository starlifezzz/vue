package com.zcj.vue.thread;

import java.util.*;
import java.util.concurrent.*;

public class theadstart {


    public static synchronized void main(String[] args) throws InterruptedException, ExecutionException {
        List<Map> jklkl = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            Map map = new HashMap();
            Random random = new Random();
            int j = random.nextInt();
            map.put("E:\\壁纸\\wallhaven-64346.png", "D:\\temp\\wallhaven-64346" + j + ".png");
            jklkl.add(map);
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 8, 1000, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<Runnable>());
        long startTime = System.currentTimeMillis();   //获取开始时间
        for (Map map : jklkl) {
            Iterator iterator = map.entrySet().iterator();
            thread1 thread1 = new thread1();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                thread1.setFilepath(entry.getKey().toString());
                thread1.setOutpath(entry.getValue().toString());
//                thread1.run();
                Future<?> submit1 = threadPoolExecutor.submit(thread1);
            }
        }
//        long endTime = System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        while (true) {
            if (threadPoolExecutor.getCompletedTaskCount() == threadPoolExecutor.getPoolSize()) {
                break;
            }
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(1000, TimeUnit.NANOSECONDS);
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}
