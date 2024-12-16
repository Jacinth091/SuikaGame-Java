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
    
    public void bindKeyActions(JComponent component) {
            InputMap inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = component.getActionMap();

            // Key press bindings
            inputMap.put(KeyStroke.getKeyStroke("UP"), "upPressed");
            inputMap.put(KeyStroke.getKeyStroke("DOWN"), "downPressed");
            inputMap.put(KeyStroke.getKeyStroke("LEFT"), "leftPressed");
            inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "rightPressed");

            // Key release bindings
            inputMap.put(KeyStroke.getKeyStroke("released UP"), "upReleased");
            inputMap.put(KeyStroke.getKeyStroke("released DOWN"), "downReleased");
            inputMap.put(KeyStroke.getKeyStroke("released LEFT"), "leftReleased");
            inputMap.put(KeyStroke.getKeyStroke("released RIGHT"), "rightReleased");

            // Define the actions
            actionMap.put("upPressed", new KeyAction(() -> upPressed = true, "UP pressed"));
            actionMap.put("downPressed", new KeyAction(() -> downPressed = true, "DOWN pressed"));
            actionMap.put("leftPressed", new KeyAction(() -> leftPressed = true, "LEFT pressed"));
            actionMap.put("rightPressed", new KeyAction(() -> rightPressed = true, "RIGHT pressed"));

            actionMap.put("upReleased", new KeyAction(() -> upPressed = false, "UP released"));
            actionMap.put("downReleased", new KeyAction(() -> downPressed = false, "DOWN released"));
            actionMap.put("leftReleased", new KeyAction(() -> leftPressed = false, "LEFT released"));
            actionMap.put("rightReleased", new KeyAction(() -> rightPressed = false, "RIGHT released"));
        }

    // Getters for the key states
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

    // Custom Action for key handling
    private static class KeyAction extends AbstractAction {
        private final Runnable action;
        private final String debugMessage;

        public KeyAction(Runnable action, String debugMessage) {
            this.action = action;
            this.debugMessage = debugMessage;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
//            System.out.println(debugMessage); // Debug message
            action.run(); // Execute the key action
        }
    }
}
