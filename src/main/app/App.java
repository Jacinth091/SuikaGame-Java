package main.app;

import main.logic.GameManager;
import main.logic.GameThread;
import main.ui.GameWindow;

public class App {

    private int windowHeight, windowWidth;
    private GameContext gameContext;

    public App(GameContext gameContext, int windowHeight, int windowWidth){
        this.windowHeight = windowHeight;
        this.windowWidth = windowWidth;
        this.gameContext = gameContext;
        
        
    }

    public void startApp(){

        java.awt.EventQueue.invokeLater(() ->{
            GameManager gameManager = new GameManager(gameContext);
            GameWindow gameWindow = new GameWindow(gameContext,windowHeight, windowWidth);
        });

    }

}
