package com.algaworks.viagem.util.jsf;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@RequestScoped
public class FacesUtil {

	@Inject
	private FacesContext context;
	
	public void info(String descricao) {
		msg(FacesMessage.SEVERITY_INFO, descricao);
	}
	
	public void error(String descricao) {
		msg(FacesMessage.SEVERITY_ERROR, descricao);
	}
	
	private void msg(Severity severidade, String descricao) {
		FacesMessage msg = new FacesMessage(descricao);
		msg.setSeverity(severidade);
		context.addMessage(null, msg);
	}
	
	@Produces
	public FacesContext produzirFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
}