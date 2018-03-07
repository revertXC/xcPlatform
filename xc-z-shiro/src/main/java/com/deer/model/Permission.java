package com.deer.model;

import com.deer.shiro.base.BaseEntityShiro;

/**
 * 资源与操作绑定类
 */
public class Permission extends BaseEntityShiro {
    private Long resourceId;

    private Long operationId;

    private Resource resource;

    private Operation operation;

    private String permissionStr; // resource + operation

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getPermissionStr() {
        permissionStr = resource.getCode()+":"+operation.getCode();
        return permissionStr;
    }

}