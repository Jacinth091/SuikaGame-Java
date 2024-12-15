/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package main.logic;

/**
 *
 * @author PCC
 */
public class GameEnums {
    public enum Difficulty{
        EASY,
        MEDIUM,
        HARD;
    };

    public enum GameMode {
        SINGLE_PLAYER,
        MULTIPLAYER;
    }

    public enum GameState {
        Play,
        Pause,
        Restarting,
        GameOver
    }
}
