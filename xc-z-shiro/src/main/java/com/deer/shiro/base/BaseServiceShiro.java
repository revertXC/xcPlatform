package com.deer.shiro.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceShiro<T extends BaseEntityShiro, Mapper extends BaseMapperShiro<T>> {
    @Autowired
    private Mapper mapper;

    public int deleteByPrimaryKey(Long id){
        return mapper.deleteByPrimaryKey(id);
    }

    public int insert(T entity){
        return mapper.insert(entity);
    }

    public int insertSelective(T entity){
        return mapper.insertSelective(entity);
    }

    public T selectByPrimaryKey(Long id){
        return mapper.selectByPrimaryKey(id);
    }

    public List<T> selectAll(){
        return mapper.selectAll();
    }

    public List<T> selectByEntity(T entity){
        return mapper.selectByEntity(entity);
    }

    public int updateByPrimaryKeySelective(T entity){
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public int updateByPrimaryKey(T entity){
        return mapper.updateByPrimaryKey(entity);
    }


}
