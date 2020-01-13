package com.zcj.vue.dao;

import com.zcj.vue.entity.WeloveMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WeloveMenuDao {
    int deleteByPrimaryKey(Long id);

    int insert(WeloveMenu record);

    int insertSelective(WeloveMenu record);

    WeloveMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WeloveMenu record);

    int updateByPrimaryKey(WeloveMenu record);

    List<WeloveMenu> getAllData(@Param("weloveMenu")WeloveMenu weloveMenu);

}
