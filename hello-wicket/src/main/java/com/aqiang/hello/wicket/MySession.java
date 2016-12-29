package com.aqiang.hello.wicket;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class MySession extends AuthenticatedWebSession {

	public MySession(Request request) {
		super(request);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean authenticate(String username, String password) {
		return false;
	}

	@Override
	public Roles getRoles() {
		return null;
	}

}
