package com.zcj.vue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Controller
public class resttempletest {

    @RequestMapping("/rest")
    public void jklj(@RequestParam("name") String ddd) {
        System.out.println("请求到了" + ddd);
    }

    @RequestMapping("/file")
    @ResponseBody
    public List filelist(String filepath) {
        List list = new ArrayList();
        File file = new File("E://");
        Map filemap = new HashMap();
        Map dictorymap = new HashMap();
        String nowpath = "";
        String lastpath = "";
        if (filepath != null) {
            filepath = filepath.replaceAll(" ", " ");
            file = new File(filepath);
            try {
//                dictorymap.put("now", file.getParentFile().getPath());

                lastpath = file.getParentFile() != null ? file.getParentFile().getPath() : filepath;
                nowpath = filepath;
            } catch (Exception e) {
                e.printStackTrace();
//                dictorymap.put("now", filepath);
                lastpath = filepath;
                nowpath = filepath;
            }
        } else {
            nowpath = file.getPath();
        }
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                filemap.put(file1.getName(), file1.getPath());

            } else {
                dictorymap.put(file1.getName(), file1.getPath());
            }
        }
        list.add(filemap);
        list.add(dictorymap);
        list.add(lastpath);
        list.add(nowpath);
        return list;
    }

    @RequestMapping("/getfile")
    public void getfile(String filepath, HttpServletRequest request, HttpServletResponse response) {
        File file = new File(filepath);
        response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
        response.setContentType("application/octet-stream;charset=UTF-8");
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @ResponseBody
    @RequestMapping("/upload")
    public Map uploadfile(@RequestParam("multipartFile") MultipartFile[] multipartFile, String savepath) throws IOException {
        Map relsout = new HashMap();
        OutputStream outputStream = null;
        try {
            for (MultipartFile multipartFile1 : multipartFile) {
                File file = new File(savepath + "\\" + multipartFile1.getOriginalFilename());
                outputStream = new FileOutputStream(file);
                byte[] bytes = multipartFile1.getBytes();
                outputStream.write(bytes);
            }
        } finally {
            outputStream.flush();
            outputStream.close();
        }
        relsout.put("resoult", true);
        relsout.put("showpath", savepath);
        return relsout;
    }


    @RequestMapping("/editproperties")
    @ResponseBody
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
        properties.setProperty("fuck", "122333");
        OutputStream outputStream = new FileOutputStream(new File(filePath + "\\src\\main\\resources\\static\\jdbc.properties"));
        properties.store(outputStream, "");
        outputStream.flush();
        outputStream.close();
        return peizhi;
    }

    @RequestMapping("/test")
    public void test() {
        File file = new File("E:\\NetSarang Computer".toString());
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file.getName());
        }
    }
}
