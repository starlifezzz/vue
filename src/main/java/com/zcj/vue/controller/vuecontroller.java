package com.zcj.vue.controller;


import com.zcj.vue.entity.StudentExample;
import com.zcj.vue.entity.menu;
import com.zcj.vue.entity.user;
import com.zcj.vue.mapper.StudentDao;
import com.zcj.vue.mapper.UserMapper;
import com.zcj.vue.springcode.sona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@CrossOrigin
@RestController
@RequestMapping("/vue")
public class vuecontroller {
    private final UserMapper userMapper;
    private final StudentDao studentDao;

    @Autowired
    public vuecontroller(UserMapper userMapper, StudentDao studentDao) {
        this.userMapper = userMapper;
        this.studentDao = studentDao;
    }

    @Autowired

    /**
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    public List test() {
        List list = new ArrayList();
        sona sona = new sona();
        sona.setList(list);
        sona.setName("fsdfsd");
        sona.setPassword("sdfsd");
        sona.setIconclass("el-icon-plus");
        sona.setTitle("最新评论");

        sona sonaa = new sona();
        sonaa.setList(list);
        sonaa.setName("fsdfsd");
        sonaa.setPassword("sdfsd");
        sonaa.setIconclass("el-icon-platform-eleme");
        sonaa.setTitle("发布帖子");


        sona sonabb = new sona();
        sonabb.setList(list);
        sonabb.setName("aaaaaa");
        sonabb.setPassword("sdfsd");
        sonabb.setIconclass("el-icon-s-cooperation");
        sonabb.setTitle("二手交易");


        sona sonacc = new sona();
        sonacc.setList(list);
        sonacc.setName("fsdfsd");
        sonacc.setPassword("sdfsd");
        sonacc.setIconclass("el-icon-s-cooperation");
        sonacc.setTitle("食物列表");


        List j = new ArrayList();
        j.add(sona);
        j.add(sonaa);
        j.add(sonabb);
        j.add(sonacc);


        return j;
    }


    @RequestMapping(value = "/showdetail", method = RequestMethod.POST)
    public Map showdetail(@RequestBody HashMap<String, Integer> acctleid) {
        Map map = new HashMap();
        switch (acctleid.get("acctleid")) {
            case 1:
                map.put("title", "最新评论");
                map.put("concent", "你在这里可以对帖子进行评论，互怼");
                map.put("date", Calendar.getInstance().get(Calendar.YEAR));
                break;
            case 2:
                map.put("title", "发布帖子");
                map.put("concent", "你在这里可以发表一些最新的东西，最潮，最fashion");
                map.put("date", Calendar.getInstance().get(Calendar.YEAR));
                break;
            case 3:
                map.put("title", "二手交易");
                map.put("concent", "你在这里可以出售你的闲置物品，卖给别人，发家致富");
                map.put("date", Calendar.getInstance().get(Calendar.YEAR));
                break;
            case 4:
//                map.put("title", "食物");
//                StringBuilder html = new StringBuilder("<svg class=icon aria-hidden=true><use xlink:href=#icon-nailao></use></svg>");
//                html.append("<svg class=icon aria-hidden=true><use xlink:href=# icon-regou></use></svg>");
//                map.put("concent", html);
//                map.put("date", Calendar.getInstance().get(Calendar.YEAR));

                menu menu = new menu();
                menu.setType("jpg");
                menu.setMenuName("哇哈哈");
                menu.setClassName("嘎嘎嘎");
                menu.setMenuIcon("图标");
                menu.setKkk("jkljl");

                sona sonadd = new sona();
                sonadd.setName("fsdfsd");
                sonadd.setPassword("sdfsd");
                sonadd.setIconclass("el-icon-s-cooperation");
                sonadd.setTitle("vue嵌套测试");

                menu.setSona(sonadd);
                map.put("jjj", menu);
                break;
            default:
                break;
        }
        return map;
    }

    /**
     * 返回菜单接口
     *
     * @return 菜单列表
     */
    @RequestMapping("/getmenu")
    public Map getmenu() {
        HashMap menu = new HashMap();
        com.zcj.vue.entity.menu menu1 = new menu();
        com.zcj.vue.entity.menu menu2 = new menu();
        com.zcj.vue.entity.menu menu3 = new menu();
        com.zcj.vue.entity.menu menu4 = new menu();
        com.zcj.vue.entity.menu menu5 = new menu();
        com.zcj.vue.entity.menu menu6 = new menu();
        menu1.setMenuIcon("el-icon-search");
        menu1.setMenuName("搜索");
        menu1.setClassName("search check");
        menu1.setType("");

        menu2.setMenuIcon("el-icon-edit");
        menu2.setMenuName("编辑");
        menu2.setClassName("edit check");
        menu2.setType("primary");


        menu3.setMenuIcon("el-icon-check");
        menu3.setMenuName("成功");
        menu3.setClassName("check");
        menu3.setType("success");


        menu4.setMenuIcon("el-icon-message");
        menu4.setMenuName("信息");
        menu4.setClassName("message check");
        menu4.setType("info");


        menu5.setMenuIcon("el-icon-star-off");
        menu5.setMenuName("星星");
        menu5.setClassName("check");
        menu5.setType("warning check");


        menu6.setMenuIcon("el-icon-delete");
        menu6.setMenuName("删除");
        menu6.setClassName("check");
        menu6.setType("danger");

        menu.put("a", menu1);
        menu.put("b", menu2);
        menu.put("c", menu3);
        menu.put("d", menu4);
        menu.put("e", menu5);
        menu.put("f", menu6);

        return menu;
    }

    @RequestMapping(value = "/showdetaildata", method = RequestMethod.POST)
    public Map showdetaildata(@RequestBody HashMap<String, Integer> acctleid) {
        Map map = new HashMap();
        menu menu = new menu();
        menu.setType("jpg");
        menu.setMenuName("我是menuname");
        menu.setClassName("我是classname");
        menu.setMenuIcon("图标");
        sona sonadd = new sona();
        sonadd.setName("fsdfsd");
        sonadd.setPassword("sdfsd");
        sonadd.setIconclass("el-icon-s-cooperation");
        sonadd.setTitle("vue嵌套测试");

        menu.setSona(sonadd);
        map.put("jjj", menu);
//        map.put("哈哈哈", "你好吗");
        return map;
    }

    @RequestMapping("/pgtest")
    public void getpguser() {
        user user = new user();
        user.setId(1);
        List<com.zcj.vue.entity.user> getuser = userMapper.getuser();
        for (com.zcj.vue.entity.user user1 : getuser) {
            System.out.println(user1);
        }
    }

}
