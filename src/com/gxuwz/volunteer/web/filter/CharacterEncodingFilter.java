package com.gxuwz.volunteer.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 定义字符编码过滤器
 * @author 演示
 *
 */
public class CharacterEncodingFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse  resp,
			FilterChain chain) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig config) throws ServletException {
	}

}
