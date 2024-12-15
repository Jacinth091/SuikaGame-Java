///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package main.logic;
//
//import backend.Database.DatabaseManager;
//import backend.Images;
//import main.PlayerData.MultiManager;
//import main.PlayerData.Session;
//import main.ui.CreateMultiPlayer;
//import main.ui.GameOver;
//import main.ui.GameOverMulti;
//import main.ui.HomeForm;
//import main.ui.Loading;
//import main.ui.MultiPlayer;
//import main.ui.PauseFrame;
//import main.ui.SinglePlayer;
//
///**
// *
// * @author PCC
// */
//public class AppContext {
//    private static AppContext instance;
////    private MainThread gameThread;
//    private DatabaseManager dbManager;
//    private Session session;
//    private MultiManager multiManager;
//    
//    private GameLogic gameLogic;
//    private Images imgs;
//
//    
//    private GameEnums.GameMode gameMode;
//    private GameEnums.GameState gameState;
//    private GameStructure game;
//    
//    private CreateMultiPlayer createMulti;
//    private Loading loadingScreen;
//    private GameOver gameOver;
//    private GameOverMulti gameOverMulti;
//    private PauseFrame pauseScreen;
//    private SinglePlayer singlePlayer;
//    private MultiPlayer multiPlayer;
////    private HomeForm1 homeForm; 
//    
//    private AppContext(){
//
//    }
//    
//
//    public static synchronized AppContext getInstance(){
//        if(instance == null){
//            instance = new AppContext();
//        }
//
//        return instance;
//    }
//
//    public DatabaseManager getDbManager() {
//        if (dbManager == null) {
//            dbManager = DatabaseManager.getInstance();
//        }
//        return dbManager;
//    }
//
//    public Session getSession() {
//        if (session == null) {
//            session = Session.getInstance();
//        }
//        return session;
//    }
//
//    public Images getImageHelper() {
//        if (imgs == null) {
//            imgs = Images.getInstance();
//        }
//        return imgs;
//    }
//    
//    
//
//    
//    public Loading getLoadingScreen() {
//        if (loadingScreen == null) {
//            loadingScreen = Loading.getInstance();
//        }
//        return loadingScreen;
//    }
//
//    public GameEnums.GameMode getGameMode() {
//        return gameMode;
//    }
//
//    public void setGameMode(GameEnums.GameMode gameMode) {
//        this.gameMode = gameMode;
//    }
//
//    public GameEnums.GameState getGameState() {
//        return gameState;
//    }
//
//    
//    public SinglePlayer getSinglePlayer(AppContext appContext) {
//        if (singlePlayer == null) {
//            singlePlayer = SinglePlayer.getInstance(appContext); // Ensure AppContext is passed
//        }
//        return singlePlayer;
//    }
//
//    public void resetSinglePlayer() {
//        if (singlePlayer != null) {
//            singlePlayer.dispose(); // Dispose of UI resources
//            SinglePlayer.resetInstance(); // Reset the singleton instance
//            singlePlayer = null; // Clear the reference in AppContext
//        }
//    }
//
//
//    public MultiPlayer getMultiPlayer(AppContext appContext) {
//        if (multiPlayer == null) {
//            multiPlayer = MultiPlayer.getInstance(appContext); // Ensure AppContext is passed
//        }
//        return multiPlayer;
//    }
//
//    public void resetMultiPlayer() {
//        if (multiPlayer != null) {
//            multiPlayer.dispose(); // Dispose of UI resources
//            MultiPlayer.resetInstance(); // Reset the singleton instance
//            multiPlayer = null; // Clear the reference in AppContext
//        }
//    }
//    
//    public GameOver getGameOver(AppContext appContext) {
//        if (gameOver == null) {
//            gameOver = GameOver.getInstance(appContext);
//        }
//        return gameOver;
//    }
//
//    public void resetGameOver() {
//        if (gameOver != null) {
//            gameOver.dispose();
//            GameOver.resetInstance();
//            gameOver = null;
//        }
//    }
//    
//    public GameLogic getGameLogic(GameEnums.GameMode gameMode) {
//        if (gameLogic == null) {
//            gameLogic = GameLogic.getInstance(this, gameMode);
//        }
//        return gameLogic;
//    }
//
//    public void resetGameLogic() {
//        if (gameLogic != null) {
//            gameLogic.dispose();
//            GameLogic.resetInstance();
//            gameLogic = null;
//        }
//    }
//    
//    
//    public GameOverMulti getGameOverMulti(AppContext appContext) {
//        if (gameOverMulti == null) {
//            gameOverMulti = GameOverMulti.getInstance(appContext);
//        }
//        return gameOverMulti;
//    }
//
//    public void resetGameOverMulti() {
//        if (gameOverMulti != null) {
//            gameOverMulti.dispose();
//            GameOverMulti.resetInstance();
//            gameOverMulti = null;
//        }
//    }
//    public CreateMultiPlayer getCreateMulti(AppContext appContext) {
//        if (createMulti == null) {
//            createMulti = CreateMultiPlayer.getInstance(appContext);
//        }
//        return createMulti;
//    }
//
//    public void resetCreateMultiPlayer() {
//        if (createMulti != null) {
//            createMulti.dispose();
//            CreateMultiPlayer.resetInstance();
//            createMulti = null;
//        }
//    }
//    public PauseFrame getPauseScreen(AppContext appContext) {
//        if (pauseScreen == null) {
//            pauseScreen = PauseFrame.getInstance(appContext);
//        }
//        return pauseScreen;
//    }
//
//    public void resetPauseFrame() {
//        if (pauseScreen != null) {
//            pauseScreen.dispose();
//            PauseFrame.resetInstance();
//            pauseScreen = null;
//        }
//    }
//
//
//    public GameStructure getGame() {
//        return game;
//    }
//
//    public void setGame(GameStructure game) {
//        this.game = game;
//    }
//
//    public MultiManager getMultiManager() {
//        return multiManager;
//    }
//
//    public void setMultiManager(MultiManager multiManager) {
//        this.multiManager = multiManager;
//    }
//    
//}
