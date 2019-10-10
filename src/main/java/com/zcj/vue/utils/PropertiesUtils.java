package com.zcj.vue.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtils {

    /**
     * 修改propertis方法
     *
     * @return
     * @throws IOException
     */
    public Map editproperties() throws IOException {
        Properties properties = new Properties();
        File file = new File("");
        Map<String, String> peizhi = new HashMap<>();
        String filePath = file.getCanonicalPath();
        System.out.println(filePath + "/src/resource/static/jdbc.properties");
        InputStream inputStream = new FileInputStream(new File(filePath + "\\src\\main\\resources\\static\\jdbc.properties"));
        properties.load(inputStream);
        properties.forEach((key, value) -> {
            peizhi.put(key.toString(), value.toString());
        });
        //设置值
        properties.setProperty("fuck", "122333");
        OutputStream outputStream = new FileOutputStream(new File(filePath + "\\src\\main\\resources\\static\\jdbc.properties"));
        properties.store(outputStream, "");
        outputStream.flush();
        outputStream.close();
        return peizhi;
    }
}
