package org.kelompok5.controllers;

import org.kelompok5.AppRouter;
import org.kelompok5.models.User;
import org.kelompok5.views.pages.LoginView;

public class LoginController {
    private LoginView view;
    private AppRouter router;
    private User userModel;
    String username, password;

    public LoginController(AppRouter router) {
        this.router = router;
        view = new LoginView();

        view.addLoginListener(e -> {
            System.out.println("Login diklik");

            username = view.getUsername();
            password = view.getUsername();

            Boolean loginSuccess = userModel.login(username, password);

            if (loginSuccess) {
                router.navigateTo("dashboard");
            } else {
                view.showError();
            }

        });

        view.addRegisterListener(e -> {
            System.out.println("Register diklik");

            router.navigateTo("register");
        });

        router.addView("login", view);
    }
}
