package com.zcj.vue.dao;


import com.zcj.vue.entity.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
     List<user> getuser();

     int insertuser(@Param("user") user user);
}
