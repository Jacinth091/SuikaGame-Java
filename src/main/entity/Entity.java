    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.app.GameContext;

/**
 *
 * @author PCC
 */
public abstract class Entity {
    private GameContext gc;
    
    protected String entityName;
    protected int worldXPos;
    protected int worldYPos;
    protected int velocity;
    protected String direction;
    protected int dirX, dirY;

    protected int spriteCounter =0;
    protected int spriteNum = 1;

    protected int runSpd;

    protected boolean collision = false;

    protected BufferedImage[] walking_sprites;
    protected Rectangle collider;

    
    
    public Entity(GameContext gc){
        this.gc = gc;

    }
    
    protected abstract void getSprites();

    protected abstract void entityMove();

    protected abstract void checkOutOfBounds();

    public abstract void getCoordinates();
    
    public abstract void draw(Graphics2D g2);
    public abstract void update();

    public GameContext getGc() {
        return gc;
    }
    
    
}

