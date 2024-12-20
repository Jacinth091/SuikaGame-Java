/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.logic;
import main.app.GameContext;
import main.eventHandlers.KeyHandler;

/**
 *
 * @author PCC
 */
public class GCFactory {
    public static GameContext createGameContext() {
        GameThread gameThread = new GameThread();
        KeyHandler keyH = new KeyHandler();

        GameContext gameContext = new GameContext(gameThread, keyH);
        return gameContext;
    }
}

