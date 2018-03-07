package com.deer.model;

import com.deer.shiro.base.BaseEntityShiro;

/**
 * 资源类
 */
public class Resource extends BaseEntityShiro {

    private String code;

    private Integer resourceType;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

}