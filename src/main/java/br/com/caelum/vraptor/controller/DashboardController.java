package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.model.Usuario;

@Path("dashboard")
@Controller
public class DashboardController {
	
	@Inject EntityManager em;
	@Inject Result result;
	
	@Get("")
	public void dashboard() {
		
	}
	
	@Post("salvausuario")
	public void salvaUsuario(Usuario usuario) {
		// validar
		// salvar no banco
		em.persist(usuario);
		// direcionar para a dashboard
		result.redirectTo(DashboardController.class).dashboard();
	}

}
