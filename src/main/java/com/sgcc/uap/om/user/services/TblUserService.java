package com.sgcc.uap.om.user.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sgcc.uap.Utils.PageUilts;
import com.sgcc.uap.Utils.VoUtils;
import com.sgcc.uap.om.user.domain.TblUser;
import com.sgcc.uap.om.user.repositories.TblUserRepository;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryFilter;
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
 * @date 2018-09-06 09:52:28
 * @since 1.0
 */
@Service
public class TblUserService implements ITblUserService {
	@Autowired
	private TblUserRepository tblUserRepository;
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private  DataSource source ;

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
		} else {
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
	 * 
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

	/**
	 * 
	 * 没有分页
	 * 
	 * @param queryCondition
	 * @return 页面请求对象
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public QueryResultObject getAll(RequestCondition queryCondition) throws Exception {
		List<QueryFilter> queryfilter = queryCondition.getQueryFilter();
		StringBuffer sb = new StringBuffer();
		String querycolumns = "userid ,username, pw, age, gender, phone, email, createdtime ";
		sb.append(" select  ");
		sb.append(querycolumns);
		sb.append(" from tbl_user u   ");
		sb.append(" where 1=1");
		QueryFilter filter = null;
		// and u.id = 9
		for (int i = 0; i < queryfilter.size(); i++) {
			filter = queryfilter.get(i);
			sb.append(" and u.").append(filter.getFieldName()).append(filter.getOperator()).append(filter.getValue());
		}
		Query query = entityManager.createNativeQuery(sb.toString());
		List<Object> list = query.getResultList();
		list = VoUtils.matchColumns(querycolumns, list);
		QueryResultObject reslut = new QueryResultObject();
		reslut.setItems(list);
		return reslut;
	}

	@Override
	public QueryResultObject getPageAll(RequestCondition queryCondition) throws Exception {
		List<QueryFilter> queryfilter = queryCondition.getQueryFilter();
		StringBuffer sb = new StringBuffer();
		String querycolumns = "userid ,username, pw, age, gender, phone, email, createdtime ";
		sb.append(" select  ");
		sb.append(querycolumns);
		sb.append(" from tbl_user u   ");
		sb.append(" where 1=1");
		QueryFilter filter = null;
		// and u.id = 9
		if(queryfilter!=null && queryfilter.size()>0)
		for (int i = 0; i < queryfilter.size(); i++) {
			filter = queryfilter.get(i);
			sb.append(" and ").append(filter.getFieldName()).append(filter.getOperator()).append(filter.getValue());
		}
		QueryResultObject rb = new QueryResultObject();
		PageUilts.page(sb.toString(), querycolumns, queryCondition.getPageIndex(), queryCondition.getPageSize(),source,entityManager,rb);
		return rb;
	}
}
