package org.kelompok5.views.pages;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainView extends JPanel {
    private JButton loginButton;

    public MainView() {
        loginButton = new JButton("Login");
        add(new JLabel("Halaman Login"));
        add(loginButton);
    }

    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }
}
