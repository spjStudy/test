package com.sgcc.uap.om.user.services;

import java.util.Map;

import com.sgcc.uap.om.user.domain.TblUser;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;

/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *
 * @author 87041
 * @date 2018-09-06 09:52:28
 * @since 1.0
 */
public interface ITblUserService {
	
	
	/**
	 * 根据主键 查询
	 * @param queryCondition
	 * @return
	 */
	public QueryResultObject getTblUserByUserid(String userid);
	/**
	 * 根据idObject删除
	 * @param idObject
	 */
	public void remove(IDRequestObject idObject);
	/**
	 * 保存
	 * @param map
	 * @return
	 */
	public TblUser saveTblUser(Map map);
	/**
	 * 根据查询条件 查询
	 * @param queryCondition
	 * @return
	 */
	public QueryResultObject query(RequestCondition queryCondition);
	/**
	 * 根据查询条件 查询
	 * @param queryall
	 * @return
	 * @throws Exception 
	 */
	public QueryResultObject  getAll(RequestCondition queryCondition) throws Exception;
	public QueryResultObject  getPageAll(RequestCondition queryCondition) throws Exception;
}
