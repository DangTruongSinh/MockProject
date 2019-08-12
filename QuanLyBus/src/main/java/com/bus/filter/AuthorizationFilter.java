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
import com.bus.service.imp.AccountService;

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
		AccountModel account = (AccountModel) request.getSession().getAttribute("account");
		AccountModel result = null;
		if (account != null)
			result = new AccountService().checkLogin(account.getUserName(), account.getPassword());
		if (url.contains("/admin"))
			if (result == null)
				response.sendRedirect("/QuanLyBus/view/login.jsp");
			else
				authorization(account, "admin", filterChain, servletRequest, servletResponse, response);
		else if (url.contains("/employee"))
			if (result == null)
				response.sendRedirect("/QuanLyBus/view/login.jsp");
			else
				authorization(account, "employee", filterChain, servletRequest, servletResponse, response);
		else if (url.contains("/customer"))
			if (result == null)
				response.sendRedirect("/QuanLyBus/view/login.jsp");
			else
				authorization(account, "customer", filterChain, servletRequest, servletResponse, response);
		else if (url.contains("/register.jsp") || url.contains("/login.jsp") || url.contains("/home-web")) {
			if (result == null)
				filterChain.doFilter(servletRequest, servletResponse);
			else
				response.sendRedirect("/QuanLyBus/" + account.getRole().getName() + "-home");
		}
		else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	private void authorization(AccountModel model, String string, FilterChain filterChain,
			ServletRequest servletRequest, ServletResponse servletResponse, HttpServletResponse response) {
		try {
			if (model != null) {
				if (model.getRole().getName().equals(string)) {
					filterChain.doFilter(servletRequest, servletResponse);
				} else {
					response.sendRedirect("/QuanLyBus/view/login.jsp");
				}
			} else {
				response.sendRedirect("/QuanLyBus/view/login.jsp");
			}
		} catch (Exception e) {
		}
	}
	@Override
	public void destroy() {

	}

}
