package com.panda.common.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String method = req.getMethod();
		List<String> methodList = Arrays.asList("DELETE", "HEAD", "PUT",
				"OPTIONS", "MKCOL", "MOVE", "TRACE", "TRACK");
		if (methodList.contains(method)) {
			res.setStatus(403);
			return;
		}
		chain.doFilter(request, response);
	}
}
