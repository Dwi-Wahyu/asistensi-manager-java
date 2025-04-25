package org.kelompok5.controllers;

import org.kelompok5.AppRouter;
import org.kelompok5.views.pages.MainView;

public class MainController {
    private MainView view;
    private AppRouter router;

    public MainController(AppRouter router) {
        this.router = router;
        view = new MainView();

        view.addLoginListener(e -> {
            System.out.println("Login diklik");
            // aksi login, validasi model, dsb.
            router.navigateTo("dashboard");
        });

        router.addView("main", view);
    }
}
