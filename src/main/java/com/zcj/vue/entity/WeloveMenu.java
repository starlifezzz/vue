package com.zcj.vue.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * welove_menu
 *
 * @author
 */
@Table(name = "welove_menu")
@Data
public class WeloveMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String menu_name;
    private String class_name;
    private String type;
    private String menu_icon;
    private Integer tree_leaf;
    private Integer parent_leaf;
    private String filtername;
    /**
     * 菜单url地址
     */
    private String menu_url;

    private List<WeloveMenu> sonmenu;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WeloveMenu other = (WeloveMenu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getMenu_name() == null ? other.getMenu_name() == null : this.getMenu_name().equals(other.getMenu_name()))
                && (this.getClass_name() == null ? other.getClass_name() == null : this.getClass_name().equals(other.getClass_name()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getMenu_icon() == null ? other.getMenu_icon() == null : this.getMenu_icon().equals(other.getMenu_icon()))
                && (this.getTree_leaf() == null ? other.getTree_leaf() == null : this.getTree_leaf().equals(other.getTree_leaf()))
                && (this.getParent_leaf() == null ? other.getParent_leaf() == null : this.getParent_leaf().equals(other.getParent_leaf()))
                && (this.getMenu_url() == null ? other.getMenu_url() == null : this.getMenu_url().equals(other.getMenu_url()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMenu_name() == null) ? 0 : getMenu_name().hashCode());
        result = prime * result + ((getClass_name() == null) ? 0 : getClass_name().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getMenu_icon() == null) ? 0 : getMenu_icon().hashCode());
        result = prime * result + ((getTree_leaf() == null) ? 0 : getTree_leaf().hashCode());
        result = prime * result + ((getParent_leaf() == null) ? 0 : getParent_leaf().hashCode());
        result = prime * result + ((getMenu_url() == null) ? 0 : getMenu_url().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", menu_name=").append(menu_name);
        sb.append(", class_name=").append(class_name);
        sb.append(", type=").append(type);
        sb.append(", menu_icon=").append(menu_icon);
        sb.append(", tree_leaf=").append(tree_leaf);
        sb.append(", parent_leaf=").append(parent_leaf);
        sb.append(", menu_url=").append(menu_url);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
