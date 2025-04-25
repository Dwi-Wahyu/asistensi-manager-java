package org.kelompok5;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class AppRouter {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Map<String, JPanel> views;

    public AppRouter() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        views = new HashMap<>();
    }

    public void addView(String name, JPanel view) {
        views.put(name, view);
        mainPanel.add(view, name);
    }

    public void navigateTo(String viewName) {
        cardLayout.show(mainPanel, viewName);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
