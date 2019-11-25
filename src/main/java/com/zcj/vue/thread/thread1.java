package com.zcj.vue.thread;

import java.io.*;

public class thread1 extends Thread {
    private String filepath;
    private String outpath;

    @Override
    public void run() {
        try {
            copyfiletodistory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void copyfiletodistory() throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            File file = new File(filepath);
            inputStream = new FileInputStream(file);
            byte[] read = new byte[inputStream.available()];
            inputStream.read(read);
            outputStream = new FileOutputStream(new File(outpath));
            outputStream.write(read);
        } finally {
            outputStream.flush();
            inputStream.close();
            outputStream.close();
        }
        System.out.println(Thread.currentThread().getName());
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getOutpath() {
        return outpath;
    }

    public void setOutpath(String outpath) {
        this.outpath = outpath;
    }

}
