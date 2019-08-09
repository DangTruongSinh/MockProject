package com.bus.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.model.AccountModel;

public class AuthorizationFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();
		AccountModel model = (AccountModel) request.getSession().getAttribute("account");
		if (url.contains("/admin"))
			authorization(model,"admin",filterChain,servletRequest,servletResponse,response);
		else if(url.contains("/employee"))
			authorization(model,"employee",filterChain,servletRequest,servletResponse,response);
		else if(url.contains("/customer"))
			authorization(model,"customer",filterChain,servletRequest,servletResponse,response);
		else if(url.contains("/register.jsp") || url.contains("/login.jsp"))
		{
			if(model == null)
				filterChain.doFilter(servletRequest, servletResponse);
			else
				response.sendRedirect("/QuanLyBus/"+model.getRole().getName()+"-home");
		}
		else{
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}



	

	private void authorization(AccountModel model, String string, FilterChain filterChain,
			ServletRequest servletRequest, ServletResponse servletResponse, HttpServletResponse response) {
		try {
			if (model != null) {
				if (model.getRole().getName().equals(string)) {
					filterChain.doFilter(servletRequest, servletResponse);
				} else{
					response.sendRedirect("/QuanLyBus/view/login.jsp");
				}
			} else {
					response.sendRedirect("/QuanLyBus/view/login.jsp");
			}
		}catch (Exception e) {	// TODO: handle exception
		}
	}

	@Override
	public void destroy() {

	}

}
