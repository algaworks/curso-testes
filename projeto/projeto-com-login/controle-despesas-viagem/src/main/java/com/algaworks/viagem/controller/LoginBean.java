package com.algaworks.viagem.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.viagem.util.jsf.FacesUtil;

@Named
@RequestScoped
public class LoginBean {

	@Inject
	private Usuario usuario;

	private String nome;
	private String senha;

	@Inject
	private FacesUtil util;
	
	@Inject
	private FacesContext context;

	public String acessar() {
		if ("admin".equals(nome) && "123".equals(senha)) {
			this.usuario.setNome(nome);
			this.usuario.setSenha(senha);
			return "Home?faces-redirect=true";
		}
		util.error("Usuário/senha inválidos!");

		return null;
	}
	
	public String sair() {
		context.getExternalContext().invalidateSession();
		return "/Login?faces-redirect=true";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
