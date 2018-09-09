package com.sgcc.uap.om.user.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sgcc.uap.om.user.services.ITblUserService;
import com.sgcc.uap.om.user.vo.TblUserVO;
import com.sgcc.uap.rest.annotation.ColumnRequestParam;
import com.sgcc.uap.rest.annotation.QueryRequestParam;
import com.sgcc.uap.rest.annotation.attribute.ViewAttributeData;
import com.sgcc.uap.rest.support.FormRequestObject;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.ViewMetaData;
import com.sgcc.uap.rest.support.WrappedResult;
import com.sgcc.uap.rest.utils.ViewAttributeUtils; 

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
@RestController
@Transactional
@RequestMapping("/tbluser")
public class TblUserController {
	private final static Logger logger = (Logger) LoggerFactory.getLogger(TblUserController.class);

	@Autowired
	private ITblUserService tblUserService;
	
	/**
	 * 根据id查询
	 * @param id
	 * @return 查询结果
	 */
	@RequestMapping(value = "/{userid}")
	public WrappedResult getByUserid(@PathVariable String userid) {
		try {
			QueryResultObject result = tblUserService.getTblUserByUserid(userid);
			logger.info("查询成功"); 
			return WrappedResult.successWrapedResult(result);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	/**
	 * 删除节点（包括所有子节点）
	 * 
	 * @param params
	 *            删除节点ID
	 * @return 删除结果
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WrappedResult deleteByIds(@RequestBody IDRequestObject idObject) {
		try {

			tblUserService.remove(idObject);
			logger.info("删除节点["+idObject+"]成功");  
			return WrappedResult.successWrapedResult(true);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	/**
	 * 保存
	 * @param params
	 * @return 保存结果
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public WrappedResult saveOrUpdate(@RequestBody FormRequestObject<Map> params) {
		try {
			QueryResultObject result = new QueryResultObject();
			Map map = (Map) params.getItems().get(0);
			result.setFormItems(tblUserService.saveTblUser(map));
			logger.info("保存数据成功"); 
			return WrappedResult.successWrapedResult(result);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	/**
	 * 查询
	 * @param requestCondition
	 * @return 查询结果
	 */
	@RequestMapping("/")
	public WrappedResult query(@QueryRequestParam("params") RequestCondition requestCondition) {

		try {
			requestCondition = new RequestCondition();
			requestCondition.setPageIndex(1);
			requestCondition.setPageSize(10);
			QueryResultObject queryResult = tblUserService.query(requestCondition);
			logger.info("查询数据成功"); 
			WrappedResult result = WrappedResult.successWrapedResult(queryResult);
			result.setErrorPage("0");
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	
	/**
	 * 从vo中获取页面展示元数据信息
	 * 
	 * @param columns
	 *            将请求参数{columns:["id","name"]}封装为字符串数组
	 * @return datas
	 */
	@RequestMapping("/meta")
	public 	WrappedResult getMetaData(
			@ColumnRequestParam("params") String[] columns) {
		try{
			List<ViewAttributeData> datas = null;
			datas = ViewAttributeUtils.getViewAttributes(columns, TblUserVO.class);
			
			
			WrappedResult wrappedResult = WrappedResult.successWrapedResult(new ViewMetaData(datas));
			return wrappedResult;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	@RequestMapping("/getAll")
	public 	WrappedResult getAll( @QueryRequestParam("params") RequestCondition requestCondition) {
		try{
			requestCondition  = new RequestCondition();
//			param.put("filter", "group_id=2&iscommon=2&_status=0");
//			JSONArray filters = new JSONArray();
//			JSONObject filterOne = new JSONObject();
//			filterOne.put("fieldName", "_status");
//			filterOne.put("operator", "is");
//			filterOne.put("value", "121");
//			filters.add(filterOne);
//			
//			param.put("filter", filters.toString());
			requestCondition.setFilter("id=9&age=32");
			
			QueryResultObject 	datas = tblUserService.getAll(requestCondition);
			return  WrappedResult.successWrapedResult(datas);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	@RequestMapping("/getPageAll")
	public 	WrappedResult getPageAll( @QueryRequestParam("params") RequestCondition requestCondition) {
		try{
			requestCondition  = new RequestCondition();
//			param.put("filter", "group_id=2&iscommon=2&_status=0");
//			JSONArray filters = new JSONArray();
//			JSONObject filterOne = new JSONObject();
//			filterOne.put("fieldName", "_status");
//			filterOne.put("operator", "is");
//			filterOne.put("value", "121");
//			filters.add(filterOne);
//			
//			param.put("filter", filters.toString());
//			requestCondition.setFilter("id=9&age=32");
			requestCondition.setPageIndex(1);
			requestCondition.setPageSize(10);
			System.out.println("大叔大婶");
				QueryResultObject 	datas = tblUserService.getPageAll(requestCondition);
			return  WrappedResult.successWrapedResult(datas);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
}
