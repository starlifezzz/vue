package com.zcj.vue.mapper;

import com.zcj.vue.entity.WeloveMenu;

import java.util.List;
import java.util.Map;

public interface WeloveMenuDao {
    int deleteByPrimaryKey(Long id);

    int insert(WeloveMenu record);

    int insertSelective(WeloveMenu record);

    WeloveMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WeloveMenu record);

    int updateByPrimaryKey(WeloveMenu record);

    List<WeloveMenu> getAllData();
}
