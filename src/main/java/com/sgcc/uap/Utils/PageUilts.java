package com.sgcc.uap.Utils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;

import com.sgcc.uap.rest.support.QueryResultObject;

public class PageUilts {
	/**
	 * 用于 services 层的原生sql分页，可根据DataSource 自动判断应用的分页方式，
	 * 
	 * @param sql
	 * @param querycolumns
	 * @param pageIndex
	 * @param pageSize
	 * @param source
	 * @param entityManager
	 * @param rb 
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings("unchecked")
	public static QueryResultObject page(String sql, String querycolumns, Integer pageIndex, Integer pageSize,
			DataSource source, EntityManager entityManager, QueryResultObject rb) throws Exception {
		String countSql = " Select count(1) itemcount from (" + sql + ")";
		String pageSql = null;
		Connection con = source.getConnection();
		DatabaseMetaData data = con.getMetaData();
		String version = data.getDatabaseProductVersion();
		String dName = data.getDriverName();
		if (dName.toUpperCase().indexOf("DB2") != -1)
			pageSql = "Select * from  (select a.* ,rownumber() over() as rc from  (" + sql + ") a  where rc between "
					+ (pageIndex - 1) * pageSize + " and " + pageIndex * pageSize;
		else if (dName.toUpperCase().indexOf("ORACLE") != -1) {
			pageSql = "Select * from  (select a.*,rownum rc from (" + sql + ") a where rownum<=" + pageIndex * pageSize
					+ ") a where a.rc>" + (pageIndex - 1) * pageSize;
		} else if (dName.toUpperCase().indexOf("MYSQL") != -1)
			pageSql = sql + " limit " + ((pageIndex - 1) * pageSize == 0 ? 0 : (pageIndex - 1) * pageSize - 1) + ","
					+ pageSize;
		else if (dName.toUpperCase().indexOf("SQL") != -1) {
			if (version.startsWith("9.00")) {
				// 待开发
			} else if (version.startsWith("10.0")) {

				// 待开发
			} else if (version.startsWith("10.50")) {
				// 待开发
			}
		}
		Query query = entityManager.createNativeQuery(countSql.toString());
		Object ob =	query.getSingleResult();
		query = entityManager.createNativeQuery(pageSql.toString());
		List<Object> list = query.getResultList();
		list = VoUtils.matchColumns(querycolumns, list);
		rb.setItems(list);
		rb.setItemCount(((BigDecimal)ob).longValue());
		return rb;
	}

}
