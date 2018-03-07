package com.deer.model;

import com.deer.shiro.base.BaseEntityShiro;

import java.io.Serializable;
import java.util.List;

public class User extends BaseEntityShiro implements Serializable {
    private String account;
    private String password;
    private String name;

    private List<Role> listRole;

    private List<Permission> listPermission;

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getListRole() {
        return listRole;
    }

    public void setListRole(List<Role> listRole) {
        this.listRole = listRole;
    }

    public List<Permission> getListPermission() {
        return listPermission;
    }

    public void setListPermission(List<Permission> listPermission) {
        this.listPermission = listPermission;
    }
}
