package com.deer.mapper.shiro;

import com.deer.common.annotation.MybatisDao;
import com.deer.model.Role;
@MybatisDao
public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}