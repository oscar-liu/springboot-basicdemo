package com.oscar.demo.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * mapper封装公共CRUD操作
 */
public interface BaseMapper<T,E extends Serializable>{
    
	/**
	 * 根据主键查找一条记录
	 */
    T selectById(E id);
    
    /**
     * 根据对象条件查找一条记录
     */
    T selectByObjCdt(T objCdt);
    
    /**
     * 根据Map条件查找一条记录
     */
    T selectByMapCdt(Map<String,Object> mapCdt);
    
    /**
     * 根据对象条件查找记录列表
     */
    List<T> selectListByObjCdt(T objCdt);
    
    /**
     * 根据Map条件查找记录列表
     */
    List<T> selectListByMapCdt(Map<String,Object> mapCdt);
    
    
    /**
     * 根据对象条件更新
     */
    int updateByObjCdt(T objCdt);
    
    /**
     * 根据Map条件更新
     */
    int updateByMapCdt(Map<String,Object> mapCdt);
    
    /**
     * 插入新记录
     */
    int insert(T obj);

    /**
     * 根据主键删除记录
     */
    int deleteById(E id);
    
    /**
     * 查询记录总数
     */
    int selectCount();
    
    /**
     * 根据Map条件查询记录总数
     */
    int selectCountByMapCdt(Map<String,Object> mapCdt);
    
    /**
     * 根据对象条件查询记录总数
     */
    int selectCountByObjCdt(T objCdt);
   
}
