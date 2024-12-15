/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.logic;

import java.util.ArrayList;

/**
 *
 * @author PCC
 */
public class GameThread implements Runnable{
    
    private Thread mainThread;
    private long FPS = 60;
    
    
    private ArrayList<GameUpdate> updates;
    private GameEnums.GameState currentState;
    
    public GameThread(){
        this.currentState = GameEnums.GameState.Play;
        updates = new ArrayList<>();
    }
    
    public void start() {
        if (mainThread == null) {
            mainThread = new Thread(this);
            mainThread.start();
        }
    }

    @Override
    public void run() {
        gameLoop();
    }


    public void gameLoop(){
        long nanoTime = 1000000000;
        double drawInterval = nanoTime / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        int frameCount = 0;
        long fpsTimer = 0;

        while (mainThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            fpsTimer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                try{
                    Thread.sleep(1000);
                    updateGame();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }

                delta--;
                frameCount++;
            }

            if (fpsTimer >= nanoTime) {
                frameCount = 0; // Reset frame count
                fpsTimer = 0;   // Move to the next second
            }
        }
    }
    
    
    
    public void updateGame(){
        System.out.println("GameState: " + currentState);
        if(null != currentState)
        switch (currentState) {
            case Play:
                
                notifyGameUpdates();
                break;
            case Pause:
                //            pauseTimer();
                try{
                    System.out.println("GAme is Paused!");
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }   break;
            case GameOver:
                System.out.println("Game Over!!!");
                break;
            default:
                break;
        }
    }
    
    public void addEventUpdate(GameUpdate eventUpdate) {
        updates.add(eventUpdate);
    }

    private synchronized void notifyGameUpdates() {
        for (GameUpdate eventUpdate : updates) {
            eventUpdate.update();
        }
    }
}
