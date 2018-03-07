package com.deer.model;

import com.deer.shiro.base.BaseEntityShiro;

import java.io.Serializable;

/**
 * 操作
 */
public class Operation extends BaseEntityShiro implements Serializable {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}