package com.deer.mapper.shiro;


import com.deer.common.annotation.MybatisDao;
import com.deer.model.Operation;

@MybatisDao
public interface OperationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Operation record);

    int insertSelective(Operation record);

    Operation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Operation record);

    int updateByPrimaryKey(Operation record);
}