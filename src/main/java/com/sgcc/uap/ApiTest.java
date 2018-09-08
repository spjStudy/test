//package com.sgcc.uap;
//
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.http.client.ClientProtocolException;
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.junit.Test;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.domain.Specification;
//
//import com.sgcc.uap.rest.support.FormRequestObject;
//import com.sgcc.uap.rest.support.IDRequestObject;
//import com.sgcc.uap.rest.support.QueryFilter;
//import com.sgcc.uap.rest.support.RequestCondition;
//import com.sgcc.uap.tuser.domain.TUser;
//import com.sgcc.uap.tuser.repositories.TUserSpec;
//import com.sgcc.uap.tuser.services.TUserService;
//import com.sgcc.uap.util.DomUtil;
//import com.sgcc.uap.util.HttpConnect;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
//public class ApiTest {
//	
//	
//   @Test
//   public void testSecuretSave() throws Exception{
//	   Map<String, String> param = new HashMap<>();
//       
//		param.put("id", "402881e6657a840b01657a93dc850000");
//		param.put("keyType", "SM4");
//       param.put("_key", "1234567890123456");
//       param.put("_status", "1");//数据库有默认值也必须传入
//       param.put("creatTime", "2019-01-01");
//       param.put("validStartTime", "2019-01-01");
//       param.put("validEndTime", "2019-02-01");
//      
//		//构建批量增加的参数
//		FormRequestObject<Map> params = new FormRequestObject<>();
//		List<Map> items = new ArrayList<>();
//		items.add(param);
//		params.setItems(items);
//
//		String jsonStr = JSONObject.fromObject(params).toString();
//		String url = "http://localhost:808/tsyssecretkey/save";
//		HttpConnect http = new HttpConnect();
//		String resultMap = http.jsonPost(url, jsonStr);
//				
//		System.out.println(resultMap);
//	}
//	
//	@Test
//	public void testHistPpd() throws Exception{
//		JSONObject param = new JSONObject();
//		param.put("pageIndex", "1");
//		param.put("pageSize", "10");
////		//排序方式 ASC,DESC
//		param.put("sorter", "DESC,updateDate");	
//		//查询条件
//		param.put("filter", "tUser=1");
//
//		
//		Map<String,String> map = new HashMap<>();
//		map.put("params", param.toString());
//		System.out.println(param.toString());
//		String url = "http://localhost:808/tsyswatchword/";
//		HttpConnect http = new HttpConnect();
//		String resultMap = http.jsonGet(url, map);
//				
//		System.out.println(resultMap);
//	}
//	
//	@Test
//	public void saveRole() throws Exception{
//		Map<String, String> param = new HashMap<>();
//        
//		param.put("id", "40281ba16537dfe2016537e9b2110001");
//		param.put("roleName", "胖大嫂角色");
//        param.put("resourceIds", "3,4,5");
//        param.put("_status", "0");//数据库有默认值也必须传入
//        param.put("validityDate", "2019-01-01");
//       
//		//构建批量增加的参数
//		FormRequestObject<Map> params = new FormRequestObject<>();
//		List<Map> items = new ArrayList<>();
//		items.add(param);
//		params.setItems(items);
//
//		String jsonStr = JSONObject.fromObject(params).toString();
//		String url = "http://localhost:808/tsysrole/save";
//		HttpConnect http = new HttpConnect();
//		String resultMap = http.jsonPost(url, jsonStr);
//				
//		System.out.println(resultMap);
//	}
//	
//	
//	
//	
//	
//	
//	
//	public static void main(String[] args) throws Exception {
////		String str = "<WrappedResult><successful>true</successful><resultValue><itemCount>0</itemCount><items><items><id>1</id><projectName>西宁、西安新能源生产运营中心智能运维平台项目</projectName><content>500V电机采购，数量1000台</content><tenderee>黄河水电公司</tenderee></items></items><dicts/></resultValue><resultHint></resultHint><errorPage></errorPage><type></type></WrappedResult>";
////		Document dm = DocumentHelper.parseText(str); 
////		Element root = dm.getRootElement();
////		Element db_element = root.element("WrappedResult");
////		List<Element> db_list = root.elements();//所有子元素
////		System.out.println(db_list.size());
//		ApiTest obj = new ApiTest();
//		//obj.testGetOne();
//		//obj.testDelete();
//		//obj.testSaveUser();
//		obj.queryByParam();
//		//obj.queryRoleGroup();
//		//obj.saveRoleGroup();
//        		
//	}
//	
//	public void saveRoleGroup() throws Exception{
//		Map<String, String> param = new HashMap<>();
//		//param.put("id", "402881e864ef82d70164ef83b4270000");
//		param.put("roleName", "test角色哇咔咔");
//		param.put("groupId", "402881e864f43e0b0164f4618f4e0003");
//        param.put("resourceIds", "3,4");
//        param.put("_status", "0");
//        param.put("validityDate", "2018-9-30");
//        param.put("remark", "测试使用");
//		//构建批量增加的参数
//		FormRequestObject<Map> params = new FormRequestObject<>();
//		List<Map> items = new ArrayList<>();
//		items.add(param);
//		params.setItems(items);
//
//		String jsonStr = JSONObject.fromObject(params).toString();
//		System.out.println(jsonStr);
//		String url = "http://localhost:808/tsysrole/save";
//		HttpConnect http = new HttpConnect();
//		String resultMap = http.jsonPost(url, jsonStr);
//				
//		System.out.println(resultMap);
//	}
//	
//	public void queryRoleGroup() throws Exception{
//		JSONObject param = new JSONObject();
//		param.put("pageIndex", "1");
//		param.put("pageSize", "10");
////		//排序方式 ASC,DESC
//		param.put("sorter", "DESC,id");	
//		
//		param.put("filter", "_status=1");
////		JSONArray filters = new JSONArray();
////		JSONObject filterOne = new JSONObject();
////		filterOne.put("fieldName", "_status");
////		filterOne.put("operator", "is");
////		filterOne.put("value", "121");
////		filters.add(filterOne);
////		
////		param.put("filter", filters.toString());
//		
//		Map<String,String> map = new HashMap<>();
//		map.put("params", param.toString());
//		System.out.println(param.toString());
//		String url = "http://localhost:808/tsysrolegroup/";
//		HttpConnect http = new HttpConnect();
//		String resultMap = http.jsonGet(url, map);
//				
//		System.out.println(resultMap);
//	}
//	
//	public Map<String, String> testMapBean() throws IllegalAccessException, InvocationTargetException{
//		Map<String, String> param = new HashMap<>();
//		param.put("username", "121");
//		param.put("_password", "121");
//		param.put("phone", "121");
//		param.put("_status", "121");
//		param.put("isDeleted", "121");
//		
//		param.put("uId", "121");
//		param.put("uT", "121");
//		param.put("cT", "121");
//		param.put("cId", "121");
//		TUser user = new TUser();
//        return param;
//	}
//	
//	/**
//	 * 根据主键获取单挑数据
//	 * @throws ClientProtocolException
//	 * @throws IOException
//	 */
//	public void testGetOne() throws Exception{
//		String url = "http://localhost:8050/two/tuser/1";
//		HttpConnect http = new HttpConnect();
//		String resultMap = http.httpGet(url, null);
//		Document dom = DocumentHelper.parseText(resultMap);
//		Map map = DomUtil.Dom2Map(dom);
//		System.out.println(map);
//	}
//	
//	/**
//	 * 根据主键删除
//	 * @throws ClientProtocolException
//	 * @throws IOException
//	 */
//	public void testDelete() throws Exception{
//		IDRequestObject idObject = new IDRequestObject();
//		String[] ids = {"10194"};
//		idObject.setIds(ids);
//		String jsonStr = JSONObject.fromObject(idObject).toString();
//		String url = "http://localhost:8050/two/tuser/delete";
//		HttpConnect http = new HttpConnect();
//		String resultMap = http.jsonPost(url, jsonStr);
//				
//		System.out.println(resultMap);
//	}
//	/**
//	 * 新增表记录
//	 * @throws ClientProtocolException
//	 * @throws IOException
//	 * @throws IllegalAccessException
//	 * @throws InvocationTargetException
//	 */
//	public void testSaveUser() throws Exception{
//		Map<String, String> param = new HashMap<>();//this.testMapBean();
//        JSONObject org = new JSONObject();
//        org.put("id", "1");
//		
////		param.put("id", "402881e864ef82d70164ef83b4270000");
//		param.put("userName", "胖大嫂");
//        param.put("loginName", "pangdasao");
//        param.put("watchword", "asdfasd");
//        param.put("organizationid", "1");
////        param.put("organizationid","1");//更新组织机构或新增用户时传入
////        param.put("userState", "0");
////        param.put("updateDate", "2018-7-30");
////        param.put("validityDate", "2018-7-30");
////        param.put("email", "999@kaka.com");
////        param.put("mobilePhone", "18899991111");
////        param.put("caNo", "123");
////        param.put("sign", "456");
////        param.put("userDesc", "测试用户");
////        param.put("roleIds", "1,2");
//		//构建批量增加的参数
//		FormRequestObject<Map> params = new FormRequestObject<>();
//		List<Map> items = new ArrayList<>();
//		items.add(param);
//		params.setItems(items);
//
//		String jsonStr = JSONObject.fromObject(params).toString();
//		String url = "http://localhost:808/tsysuser/save";
//		HttpConnect http = new HttpConnect();
//		String resultMap = http.jsonPost(url, jsonStr);
//				
//		System.out.println(resultMap);
//	}
//	
//	/**
//	 * 根据条件查询数据
//	 * @throws IOException 
//	 * @throws ClientProtocolException 
//	 */
//	public void queryByParam() throws Exception{
//		JSONObject param = new JSONObject();
//		param.put("pageIndex", "1");
//		param.put("pageSize", "10");
////		//排序方式 ASC,DESC
////		param.put("sorter", "DESC,cT");	
//		
//		param.put("filter", "group_id=2&iscommon=2&_status=0");
//		JSONArray filters = new JSONArray();
//		JSONObject filterOne = new JSONObject();
//		filterOne.put("fieldName", "_status");
//		filterOne.put("operator", "is");
//		filterOne.put("value", "121");
//		filters.add(filterOne);
//		
//		param.put("filter", filters.toString());
//		
//		Map<String,String> map = new HashMap<>();
//		map.put("params", param.toString());
//		System.out.println(param.toString());
//		System.out.println(map);
//		String url = "http://localhost:808/tsysresource/";
//		HttpConnect http = new HttpConnect();
//		String resultMap = http.jsonGet(url, map);
//				
//		System.out.println(resultMap);
////		System.out.println(Sort.Direction.DESC);
//	}
//
//}
