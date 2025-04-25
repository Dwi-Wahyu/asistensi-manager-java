package org.kelompok5;

import javax.swing.*;

import org.kelompok5.controllers.LoginController;
import org.kelompok5.controllers.RegisterController;

// import org.kelompok5.controllers.MainController;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppRouter router = new AppRouter();
            new LoginController(router);
            new RegisterController(router);

            JFrame frame = new JFrame("Asistensi Manager");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(router.getMainPanel());
            frame.setSize(400, 310);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            router.navigateTo("login"); // Tampilkan view utama
        });
    }
}
