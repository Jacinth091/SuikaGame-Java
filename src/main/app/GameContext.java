/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.app;

import main.eventHandlers.KeyHandler;
import main.logic.GameThread;

/**
 *
 * @author PCC
 */
public class GameContext {
    private GameThread gameThread;
    private final KeyHandler keyH;
    private boolean isGameRunning;
    
    
    private int windowHeight, windowWidth;
    private int gpHeight, gpWidth;

    public GameContext(GameThread gameThread, KeyHandler keyH) {
        this.windowHeight = 700;
        this.windowWidth = 650;
        this.gameThread = gameThread;
        this.keyH = keyH;
        this.isGameRunning = false;
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

    public int getWindowHeight() {
        return windowHeight;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getGpHeight() {
        return gpHeight;
    }

    public void setGpHeight(int gpHeight) {
        this.gpHeight = gpHeight;
    }

    public int getGpWidth() {
        return gpWidth;
    }

    public void setGpWidth(int gpWidth) {
        this.gpWidth = gpWidth;
    }

    
    
    
    
    public boolean isGameRunning() {
        return isGameRunning;
    }

    public GameThread getGameThread() {
        return gameThread;
    }

    public KeyHandler getKeyH() {
        return keyH;
    }
}