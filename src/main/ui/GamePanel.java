/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main.ui;

import java.awt.*;
import main.app.GameContext;
import main.entity.player.Player;
import main.eventHandlers.KeyHandler;

/**
 *
 * @author PCC
 */
public class GamePanel extends javax.swing.JPanel {
    private GameContext gameContext;
    private KeyHandler keyH;
    private Player player;

    /** 
     * Creates new form GamePanel
     * @param gameContext
     */
    public GamePanel(GameContext gameContext) {
        this.gameContext = gameContext;
        gameContext.setGpHeight(570);
        gameContext.setGpWidth(650);
        this.keyH = gameContext.getKeyH();

        this.setFocusable(true);
        this.setDoubleBuffered(true);
        this.requestFocusInWindow(); 
        
        initComponents();
        init();
        
    }
    private void init(){
        this.player = new Player(gameContext);
        gameContext.getKeyH().setupKeyBindings(this);


    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        draw(g2);

        g2.dispose();
        
    }
    
    
    private void draw(Graphics2D g2){

        player.draw(g2);

    }
    
    public void gpUpdate(){
        player.update();
        player.getCoordinates();
    }
    

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(140, 180, 249));
        setMaximumSize(new java.awt.Dimension(650, 570));
        setPreferredSize(new java.awt.Dimension(650, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
