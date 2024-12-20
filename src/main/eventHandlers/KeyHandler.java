/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.eventHandlers;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author PCC
 */
public class KeyHandler{

    
    private boolean upPressed, downPressed, leftPressed, rightPressed;
    private boolean pauseKey, mouseLocKey;
    private String[][] predefinedKeys = {
            {"UP", "upPressed", "upReleased"},
            {"DOWN", "downPressed", "downReleased"},
            {"LEFT", "leftPressed", "leftReleased"},
            {"RIGHT", "rightPressed", "rightReleased"},
            {"W", "upPressed", "upReleased"},
            {"S", "downPressed", "downReleased"},
            {"A", "leftPressed", "leftReleased"},
            {"D", "rightPressed", "rightReleased"}
        };
    private final String[][] inputKeys = {
        {"P"}, // Example: Bind "J" key for custom actions
        {"O"},
        {"K"},
        {"K"},
        {"K"},
    };
    
    public void setupKeyBindings(JComponent component) {
        InputMap inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = component.getActionMap();

        for (String[] keyConfig : predefinedKeys) {
            String key = keyConfig[0];
            String pressAction = keyConfig[1];
            String releaseAction = keyConfig[2];

            // Key press
            inputMap.put(KeyStroke.getKeyStroke(key), pressAction);
            actionMap.put(pressAction, new KeyAction(() -> updateKeyState(key, true), key + " pressed"));

            // Key release
            inputMap.put(KeyStroke.getKeyStroke("released " + key), releaseAction);
            actionMap.put(releaseAction, new KeyAction(() -> updateKeyState(key, false), key + " released"));
        }

        for (String[] inputKey : inputKeys) {
            for (String key : inputKey) {
                if (key == null || key.isEmpty()) continue; // Skip invalid keys
                KeyStroke keyStroke = KeyStroke.getKeyStroke(key);
                if (keyStroke == null) {
                    System.err.println("Invalid key: " + key);
                    continue;
                }
                String actionName = "buttonAction_" + key;
                // Bind the key to an action
                inputMap.put(keyStroke, actionName);
                actionMap.put(actionName, new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                    }
                });
            }
        }
    }

    private void updateKeyState(String key, boolean isPressed) {
        switch (key) {
            case "UP", "W" -> upPressed = isPressed;
            case "DOWN", "S" -> downPressed = isPressed;
            case "LEFT", "A" -> leftPressed = isPressed;
            case "RIGHT", "D" -> rightPressed = isPressed;
        }
//            System.out.println(key + " is now " + (isPressed ? "pressed" : "released"));
    }

    
    private static class KeyAction extends AbstractAction {
        private final Runnable action;
        private final String description;

        public KeyAction(Runnable action, String description) {
            this.action = action;
            this.description = description;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            action.run();
        }

        @Override
        public String toString() {
            return description;
        }
    }
    

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }



}
