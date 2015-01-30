package com.panda.common.util;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
public class MyMultipartResolver extends CommonsMultipartResolver {
    @Override  
    public boolean isMultipart(HttpServletRequest request) {  
     String url=request.getRequestURI();
     if("/product/ssmCreate.shtml".equals(url)||"/haoDuan/addHcode.shtml".equals(url)||"/product/updateMms.shtml".equals(url)){
    	 return super.isMultipart(request);  
     }
     return false;
    } 
}
