package com.panda.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.panda.common.vo.ResponseCode;
import com.panda.common.vo.ReturnData;

/** 
 * @ClassName: JsonInterfaceTools 
 * @Description:  
 */
public class JsonInterfaceTools {

	protected final static ObjectMapper jsonMapper = new ObjectMapper();

	private static Logger logger = LoggerFactory.getLogger(JsonInterfaceTools.class);
	
	/**
	 * 将ReturnData对象转换成JSON字符串
	 * @param returnData
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public synchronized static String parseReturnDataJson(ReturnData returnData){
		if(returnData == null){
			logger.error("转换ReturnData：参数为空");
			return getErrorMsg("转换ReturnData：参数为空", ResponseCode.PARAM_JSON);
		}

		try {
			return jsonMapper.writeValueAsString(returnData);
		} catch (JsonParseException e) {
			logger.error("转换ReturnData JsonParseException："+e.getMessage(), e.fillInStackTrace());
			return getErrorMsg("转换ReturnData JsonParseException："+e.getMessage(), ResponseCode.PARAM_JSON);
		} catch (JsonMappingException e) {
			logger.error("转换ReturnData JsonMappingException："+e.getMessage(), e.fillInStackTrace());
			return getErrorMsg("转换ReturnData JsonMappingException："+e.getMessage(), ResponseCode.PARAM_JSON);
		} catch (IOException e) {
			logger.error("转换ReturnData IOException："+e.getMessage(), e.fillInStackTrace());
			return getErrorMsg("转换ReturnData IOException："+e.getMessage(), ResponseCode.PARAM_JSON);
		}
	}
	
	
	
	/**
	 * JSON字符串转成ArrayList对象
	 * @Title: parseString2ArrayList 
	 * @Description:
	 * @param str
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public synchronized static ArrayList parseString2ArrayList(String str) throws Exception{
		if(StringUtils.isEmpty(str)){
			return null;
		}
		str = str.replace("\n", " ");
		str = str.replace("\r", " ");
		try {
			return jsonMapper.readValue(str, ArrayList.class);
		} catch (JsonParseException e) {
			throw new Exception("parseString2ArrayList : 转换参数错误  参数值："+ str+ " 错误信息" +e.getMessage(), e.fillInStackTrace());
		} catch (JsonMappingException e) {
			throw new Exception("parseString2ArrayList : 转换参数错误  参数值："+ str+ " 错误信息"+e.getMessage(), e.fillInStackTrace());
		} catch (IOException e) {
			throw new Exception("parseString2ArrayList : 转换参数错误  参数值："+ str+ " 错误信息"+e.getMessage(), e.fillInStackTrace());
		}
	}
	
	/**
	 * JSON字符串转成数组对象
	 * @Title: parseString2Array 
	 * @Description:
	 * @param str
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public synchronized static String[] parseString2Array(String str) throws Exception{
		ArrayList<String> list = parseString2ArrayList(str);
		if(list!=null && list.size()>0){
			String[] arr = new String[list.size()];
		    list.toArray(arr);
		    return arr;
		}else{
			return null;
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public synchronized static HashSet<String> parseString2HashSet(String str) throws Exception{
		if(StringUtils.isEmpty(str)){
			return null;
		}
		str = str.replace("\n", " ");
		str = str.replace("\r", " ");
		try {
			return jsonMapper.readValue(str, HashSet.class);
		} catch (JsonParseException e) {
			throw new Exception("parseString2HashSet : 转换参数错误  参数值："+ str+ " 错误信息" +e.getMessage(), e.fillInStackTrace());
		} catch (JsonMappingException e) {
			throw new Exception("parseString2HashSet : 转换参数错误  参数值："+ str+ " 错误信息"+e.getMessage(), e.fillInStackTrace());
		} catch (IOException e) {
			throw new Exception("parseString2HashSet : 转换参数错误  参数值："+ str+ " 错误信息"+e.getMessage(), e.fillInStackTrace());
		}
	}
	
	@SuppressWarnings("unchecked")
	public synchronized static HashMap<String,String> parseString2HashMap(String str) throws Exception{
		if(StringUtils.isEmpty(str)){
			return null;
		}
		str = str.replace("\n", " ");
		str = str.replace("\r", " ");
		try {
			return jsonMapper.readValue(str, HashMap.class);
		} catch (JsonParseException e) {
			throw new Exception("parseString2HashMap : 转换参数错误  参数值："+ str+ " 错误信息" +e.getMessage(), e.fillInStackTrace());
		} catch (JsonMappingException e) {
			throw new Exception("parseString2HashMap : 转换参数错误  参数值："+ str+ " 错误信息"+e.getMessage(), e.fillInStackTrace());
		} catch (IOException e) {
			throw new Exception("parseString2HashMap : 转换参数错误  参数值："+ str+ " 错误信息"+e.getMessage(), e.fillInStackTrace());
		}
	}
	
	/**
	 * 获取默认的错误JSON字符串
	 * @Title: getErrorMsg 
	 * @Description:
	 * @param desc
	 * @return
	 */
	public synchronized static String getErrorMsg(String desc){
		StringBuilder builder = new StringBuilder();
		builder.append("{\"code\":0,\"msg\":\"");
		builder.append(desc);
		builder.append("\",\"opttype\":0,");
		builder.append("\"data\":null}");
		
		return builder.toString();
	}

	/**
	 * 获取默认的错误JSON字符串
	 * @param desc 
	 * @param code 自己指定错误码。
	 * @return
	 */
	public synchronized static String getErrorMsg(String desc, int code)
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"code\":" + code + ",\"msg\":\"");
		builder.append(desc);
		builder.append("\",\"opttype\":0,");
		builder.append("\"data\":null}");

		return builder.toString();
	}

}
