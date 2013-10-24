package com.algaworks.viagem.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algaworks.viagem.controller.Usuario;

@WebFilter("*.xhtml")
public class AutorizacaoFilter implements Filter {

	@Inject
	private Usuario usuario;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		
		if (!usuario.isLogado() && !req.getRequestURI().endsWith("/Login.xhtml")
				&& !req.getRequestURI().contains("/javax.faces.resource/")) {
			res.sendRedirect(req.getContextPath() + "/Login.xhtml");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}

