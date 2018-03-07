package com.deer.model;

import com.deer.shiro.base.BaseEntityShiro;

import java.io.Serializable;
import java.util.List;


public class Role extends BaseEntityShiro implements Serializable {
    private String name;

    private List<Permission> listPermission;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getListPermission() {
        return listPermission;
    }

    public void setListPermission(List<Permission> listPermission) {
        this.listPermission = listPermission;
    }
}
