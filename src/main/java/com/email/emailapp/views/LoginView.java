package com.email.emailapp.views;

import com.email.emailapp.services.EmailService;
import com.email.emailapp.services.UserService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;

@Route("login")
public class LoginView extends Composite<LoginOverlay> {

    //    private final EmailService emailService;
    private final UserService userService;

    public LoginView(EmailService emailService, UserService userService) {
//        this.emailService = emailService;
        this.userService = userService;

        LoginOverlay loginOverlay = getContent();
        loginOverlay.setOpened(true);
        loginOverlay.setTitle("Email App");

        loginOverlay.addLoginListener(loginEvent -> {
            String username = loginEvent.getUsername();
            String password = loginEvent.getPassword();
            boolean isAuthenticated = userService.authenticateUser(username, password);
            if (isAuthenticated) {
                UI.getCurrent().navigate("email");
            } else {
//                UI.getCurrent().navigate(String.valueOf(SendEmailView.class));
                Notification.show("Bad credentials!!");
            }
        });

    }
}
