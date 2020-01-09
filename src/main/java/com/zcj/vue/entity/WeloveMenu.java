package com.zcj.vue.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * welove_menu
 * @author 
 */
@Data
public class WeloveMenu implements Serializable {
    private Long id;

    private String menuName;

    private String className;

    private String type;

    private String menuIcon;

    private static final long serialVersionUID = 1L;
}