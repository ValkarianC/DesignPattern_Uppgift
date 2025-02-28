package org.example;

import org.example.View.WelcomeMenu;

public class Main {
    public static void main(String[] args) {
        WelcomeMenu welcomeMenu = WelcomeMenu.getInstance();
        welcomeMenu.createWelcomeMenu();
    }
}