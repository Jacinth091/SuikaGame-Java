package main.app;

import main.logic.GameManager;
import main.logic.GameThread;
import main.ui.GameWindow;

public class App {

    private int windowHeight, windowWidth;
    private GameContext gameContext;

    public App(GameContext gameContext){
        this.gameContext = gameContext;

        this.windowHeight = gameContext.getWindowHeight();
        this.windowWidth = gameContext.getWindowWidth();
        
        
    }

    public void startApp(){

        java.awt.EventQueue.invokeLater(() ->{
            GameManager gameManager = new GameManager(gameContext);
            GameWindow gameWindow = new GameWindow(gameContext);
        });

    }

}
