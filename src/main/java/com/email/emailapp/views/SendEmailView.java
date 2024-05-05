package com.email.emailapp.views;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("email")
public class SendEmailView extends Composite<VerticalLayout> {

    public SendEmailView() {
        getContent().add(new H1("Welcome, send your email here."));
    }
}
