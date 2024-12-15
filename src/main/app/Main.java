/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.app;

/**
 *
 * @author PCC
 */
public class Main {
    public static void main(String[] args) {
        GameContext gameContext = GameContext.getInstance();
        App app = new App(gameContext, 500,700);

        app.startApp();
    }
}
