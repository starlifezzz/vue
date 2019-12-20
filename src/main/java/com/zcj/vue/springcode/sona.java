package com.zcj.vue.springcode;

import java.io.Serializable;
import java.util.List;

public class sona implements father, Serializable {
    private List list;
    private String name;
    private String password;
    private String title;
    private String iconclass;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconclass() {
        return iconclass;
    }

    public void setIconclass(String iconclass) {
        this.iconclass = iconclass;
    }

    @Override
    public int springioc() {
        System.out.println("im son a");
        return 0;
    }
}
