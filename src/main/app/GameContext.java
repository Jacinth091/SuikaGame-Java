/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.app;

import main.logic.GameThread;

/**
 *
 * @author PCC
 */
public class GameContext {
    public static GameContext instance;
private GameThread gameThread; // The game thread object
    private boolean isGameRunning;

    private GameContext() {
        this.isGameRunning = false;
        this.gameThread = new GameThread();
        startGame();
    }

    public static synchronized GameContext getInstance() {
        if (instance == null) {
            instance = new GameContext();
        }
        return instance;
    }

    public void startGame() {
        if (!isGameRunning) {
            isGameRunning = true;
            gameThread.start();
        }
    }

    public void stopGame() {
        isGameRunning = false;
        gameThread = null; // Allow garbage collection
    }
    
    public boolean isGameRunning() {
        return isGameRunning;
    }

    public GameThread getGameThread() {
        return gameThread;
    }
    
}
