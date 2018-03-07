package com.deer.shiro.base;

import java.util.List;

public interface BaseMapperShiro<T extends BaseEntityShiro> {
    int deleteByPrimaryKey(Long id); /*根据ID 删除*/

    int insert(T record);   /*增加*/

    int insertSelective(T entity); /*非空增加*/

    T selectByPrimaryKey(Long id); /*根据ID查询*/

    List<T> selectAll(); /*查询全部*/

    List<T> selectByEntity(T entity);

    int updateByPrimaryKeySelective(T entity); /*非空修改*/

    int updateByPrimaryKey(T entity); /*修改*/
}
