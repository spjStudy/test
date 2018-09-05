package com.sgcc.uap.om.user.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sgcc.uap.om.user.domain.TblUser;
import com.sgcc.uap.om.user.repositories.TblUserRepository;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.utils.CrudUtils;
import com.sgcc.uap.rest.utils.RestUtils;

/**
 * <b>概述</b>：<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 87041
 * @date 2018-09-05 09:15:51
 * @since 1.0
 */
@Service
public class TblUserService  implements ITblUserService{
	@Autowired
	private TblUserRepository tblUserRepository;
	
	@Override
	public QueryResultObject getTblUserByUserid(String userid) {
		TblUser tblUser = tblUserRepository.findOne(userid);
		return RestUtils.wrappQueryResult(tblUser);
	}
	@Override
	public void remove(IDRequestObject idObject) {
		String[] ids = idObject.getIds();
		for (String id : ids)
			tblUserRepository.delete(id);
	}
	@Override
	public TblUser saveTblUser(Map map) {
		
		TblUser tblUser = new TblUser();
		if (map.containsKey("userid")) {
			
			try {
				String userid = (String) map.get("userid");
				tblUser = tblUserRepository.findOne(userid);
				CrudUtils.mapToObject(map, tblUser, userid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			try {
				BeanUtils.populate(tblUser, map);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return tblUserRepository.save(tblUser);
	}
	@Override
	public QueryResultObject query(RequestCondition queryCondition) {
		PageRequest request = this.buildPageRequest(queryCondition);
		Page<TblUser> tblUser = tblUserRepository.findAll(request);
		List<TblUser> result = null;
		long count = 0;
		result = tblUser.getContent();
		count = tblUser.getTotalElements();
		return RestUtils.wrappQueryResult(result, count);
	}

	/**
	 * 构建PageRequest
	 * @param queryCondition
	 * @return 页面请求对象
	 */
	private PageRequest buildPageRequest(RequestCondition queryCondition) {
		int pageIndex = 1, pageSize = 1;
		if (queryCondition.getPageIndex() != null && queryCondition.getPageSize() != null) {
			pageIndex = queryCondition.getPageIndex();
			pageSize = queryCondition.getPageSize();
		}
		return new PageRequest(pageIndex - 1, pageSize, null);
	}
}
