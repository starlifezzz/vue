package com.zcj.vue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class resttempletest {

    @RequestMapping("/rest")
    public void jklj(@RequestParam("name") String ddd) {
        System.out.println("请求到了" + ddd);
    }

    @RequestMapping("/file")
    @ResponseBody
    public List filelist(String filepath) throws FileNotFoundException {
        List list = new ArrayList();
        File file = new File("E://");
        if (filepath != null) {
            file = new File(filepath);
        }

        File[] files = file.listFiles();
        Map filemap = new HashMap();
        Map dictorymap = new HashMap();
        dictorymap.put("now", file.getPath());
        for (File file1 : files) {
            if (file1.isDirectory()) {
                filemap.put(file1.getName(), file1.getPath());

            } else {
                dictorymap.put(file1.getName(), file1.getPath());
            }
        }
        list.add(filemap);
        list.add(dictorymap);
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
}
