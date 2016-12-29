package com.aqiang.hello.wicket.page;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

public class LoginPage extends WebPage {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		StatelessForm<LoginPage> form = new StatelessForm<LoginPage>("form") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				boolean authResult = AuthenticatedWebSession.get().signIn(username, password);
				if (authResult)
					continueToOriginalDestination();
			}
		};
		form.setDefaultModel(new CompoundPropertyModel<LoginPage>(this));
		form.add(new TextField<String>("username").setRequired(true));
		form.add(new PasswordTextField("password"));
		form.add(new SubmitLink("submit"));
		add(form);
	}
}
