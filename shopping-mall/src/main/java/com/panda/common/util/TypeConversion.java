package com.panda.common.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;


public class TypeConversion {
	public static Integer string2Integer(String str) {
		Integer result = null;
		try {
			if (StringUtils.isNotEmpty(str)) {
				Pattern pattern = Pattern.compile("[0-9]*");
				Matcher isNum = pattern.matcher(str);
				if (isNum.matches() && str.length() <= 8) {
					result = Integer.parseInt(str);
				}
			}
		} catch (Exception e) {
		}
		return result;

	}

	public static Map<String, Object> typeConversion(Class<?> object,
			Map<String, Object> paramsMap) {
		List<Field> fieldAll = new ArrayList<Field>(Arrays.asList(object
				.getDeclaredFields()));
		Map<String, Object> vars = new HashMap<String, Object>();
		for (int i = 0; i < fieldAll.size(); i++) {
			String key = fieldAll.get(i).getName();
			String value = "";
			String type = fieldAll.get(i).getGenericType().toString();
			if (type.lastIndexOf(".") > 0) {
				value = type
						.substring(type.lastIndexOf(".") + 1, type.length());
			} else {
				value = type;
			}
			vars.put(key, value);
		}
		Set<String> varsSet = vars.keySet();
		Set<String> paramsSet = paramsMap.keySet();
		Map<String, Object> map = new HashMap<String, Object>();
		for (String str : paramsSet) {
			if (varsSet.contains(str)) {
				Object value = paramsMap.get(str);
				if (value != null) {
					if (value instanceof String) {
						if (!"".equals(((String) value).trim())) {
							map.put(str, getObject(value, vars.get(str)));
						}
					} else if (value instanceof Object[]) {
						Object[] objs = (Object[]) value;
						if (objs.length > 0) {
							for (int m = 0; m < objs.length; m++) {
								objs[m] = getObject(objs[m], vars.get(str));
							}
						}
						map.put(str, objs);
					}else{
						map.put(str, value);
					}
				}
			}
		}
		return map;
	}

	public static Object getObject(Object src, Object type) {
		Object res = src;
		if ("int".equals(type) || "Integer".equals(type)) {
			if (src instanceof String) {
				res = Integer.parseInt((String) src);
			}
		}
		return res;
	}
	
	public static List<Object> getHql(StringBuilder hql , Map<String,Object> paramsMap){
		Set<String> keyset = paramsMap.keySet();
		List<Object> values = new ArrayList<Object>();
		for(String key : keyset){
			Object value = paramsMap.get(key);
			if(value instanceof Object[]){
				Object[] objs = (Object[])value;
				if(objs.length>0){
					hql.append(" and ( ");
					for(Object obj : objs){
						hql.append(" "+key+"=? or ");
						values.add(obj);
					}

					hql.delete(hql.length()-3,hql.length());
					hql.append(" ) ");
				}
			}else{
				hql.append(" and "+key+"=? ");
				values.add(paramsMap.get(key));
			}
		}
		return values;
	}
	
	public static void main(String[] args) {
		// /typeConversion(OrderPo.class);
		System.out.println(string2Integer("asdf"));
	}
}
