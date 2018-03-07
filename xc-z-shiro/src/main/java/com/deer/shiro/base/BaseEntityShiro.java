package com.deer.shiro.base;

import java.io.Serializable;
import java.util.Date;

public class BaseEntityShiro implements Serializable {

    private Long id; /*编号*/

    private String description; /*描述*/

    private Integer deleted; /*是否删除 0否 1是*/

    private Long updateBy; /*最后修改人*/

    private Date updateDate; /*最后修改时间*/

    private Long createBy; /*创建人*/

    private Date createDate; /*创建时间*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
