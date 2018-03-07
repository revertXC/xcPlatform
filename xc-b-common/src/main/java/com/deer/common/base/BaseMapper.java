package com.deer.common.base;

import java.util.List;

public interface BaseMapper<T extends BaseEntity> {

    int deleteByPrimaryKey(Long id); /*根据ID 删除*/

    int insert(T record);   /*增加*/

    int insertSelective(T record); /*非空增加*/

    T selectByPrimaryKey(Long id); /*根据ID查询*/

    List<T> selectAll(); /*查询全部*/

    int updateByPrimaryKeySelective(T record); /*非空修改*/

    int updateByPrimaryKey(T record); /*修改*/
}
