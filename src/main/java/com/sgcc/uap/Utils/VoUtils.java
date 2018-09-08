package com.sgcc.uap.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class VoUtils {
	/**
	 *  添加key
	 * @param querycolumns
	 * @param arrList
	 * @return
	 * @throws Exception
	 * @author spj
	 *  
	 */

	public static List<Object> matchColumns(String querycolumns, List<Object> arrList) throws Exception {
		if ((arrList == null || arrList.size() == 0) || (StringUtils.isBlank(querycolumns)))
			return null;
		String[] strArr = querycolumns.split(",");
		List<Object> list = new ArrayList<Object>();
		Map<String, Object> map = null;
		for (int i = 0; i < arrList.size(); i++) {
			Object[] obj = (Object[]) arrList.get(i);
			map = new HashMap<String, Object>();
			for (int j = 0; j < strArr.length; j++) {
				map.put(strArr[j].trim(), obj[j]);
			}
			list.add(map);
		}
		return list;
	}
}
