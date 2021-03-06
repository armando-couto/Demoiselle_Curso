package br.gov.serpro.inscricao.security;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.User;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

@Alternative
public class Autenticador implements Authenticator {

	private static final long serialVersionUID = 1L;

	@Inject
    private ResourceBundle bundle;
	
	@Inject
	private Credenciais credenciais;
	
	@Override
    public boolean authenticate() {
        boolean autenticado = false;
        if (credenciais.getNome().equals("secretaria") && credenciais.getSenha().equals("segredo")) {
            autenticado = true;
        } else {
            throw new RuntimeException(bundle.getString("usuarioNaoAutenticado"));
        }
        return autenticado;
    }

	@Override
	public User getUser() {
		return new User() {

			private static final long serialVersionUID = 1L;

			@Override
			public void setAttribute(Object arg0, Object arg1) {

			}

			@Override
			public String getId() {
				return null;
			}

			@Override
			public Object getAttribute(Object arg0) {
				return null;
			}
		};
	}

	@Override
	public void unAuthenticate() {
	}
}