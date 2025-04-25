package org.kelompok5.controllers;

import org.kelompok5.AppRouter;
import org.kelompok5.views.pages.RegisterView;

public class RegisterController {
    private RegisterView view;
    private AppRouter router;
    String username, password;

    public RegisterController(AppRouter router) {
        this.router = router;
        view = new RegisterView();

        view.addRegisterListener(e -> {
            System.out.println("Register diklik");
        });

        view.addBackListener(e -> {
            router.navigateTo("login");
        });

        router.addView("register", view);
    }
}
