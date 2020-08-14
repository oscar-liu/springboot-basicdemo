package com.oscar.demo.service.lmpl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.oscar.demo.mapper.BaseMapper;
import com.oscar.demo.service.BaseService;
import com.oscar.demo.utils.ReType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 通用service层{@link=BaseService}实现类
 */
public abstract class BaseServiceImpl<T,E extends Serializable> implements BaseService<T,E> {
	
	  public abstract BaseMapper<T,E> getMapper();
	  
	  @Override
	  public T selectById(E id) {
	    return getMapper().selectById(id);
	  }
	  
	  @Override
	  public T selectByObjCdt(T objCdt) {
	    return getMapper().selectByObjCdt(objCdt);
	  }
	  
	  @Override
	  public T selectByMapCdt(Map<String,Object> mapCdt) {
	    return getMapper().selectByMapCdt(mapCdt);
	  }
	  
	  @Override
	  public List<T> selectListByObjCdt(T objCdt){
	      return getMapper().selectListByObjCdt(objCdt);
	  }
	  
	  @Override
	  public List<T> selectListByMapCdt(Map<String,Object> mapCdt){
	      return getMapper().selectListByMapCdt(mapCdt);
	  }
	  
	  @Override
	  public ReType selectByPage(T t, int page, int limit){
		Page<T> tPage= PageHelper.startPage(page,limit);
	    List<T> tList=this.selectListByObjCdt(t);	    
	    ReType reType=new ReType(tPage.getTotal(),tList);
	    return reType;
	  }
	  
	  @Override
	  public int insert(T model) {
	    return getMapper().insert(model);
	  }
	  
	  @Override
	  public int updateByObjCdt(T model) {
	    return getMapper().updateByObjCdt(model);
	  }

	  @Override
	  public int deleteById(E id) {
	    return getMapper().deleteById(id);
	  }
	  
	  @Override
	 public int selectCount(){
		 return getMapper().selectCount();
	 }
	 
	 @Override
	 public int selectCountByMapCdt(Map<String,Object> mapCdt){
		 return getMapper().selectCountByMapCdt(mapCdt);
	 }
	 
	 @Override
	 public int selectCountByObjCdt(T objCdt){
		 return getMapper().selectCountByObjCdt(objCdt);
	 }

}
