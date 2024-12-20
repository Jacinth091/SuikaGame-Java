package main.entity.player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import main.app.GameContext;
import main.entity.Entity;

/**
 *
 * @author PCC
 */
public class Player extends Entity {

    private final int gameWidth;
    private final int gameHeight;

    public Player(GameContext gc) {
        super(gc);
        this.gameWidth = gc.getGpWidth(); // Set the game width
        this.gameHeight = gc.getGpHeight(); // Set the game height
        setDefaults();
    }

    private void setDefaults() {
        entityName = "player";
        worldXPos = (gameWidth / 2);
        worldYPos = 100;
        collider = new Rectangle(worldXPos, worldYPos, 50, 50); // Updated collider size

        velocity = 10;
        runSpd = 0;
        direction = "up";
        dirX = 0;
        dirY = 0;
    }

    @Override
    protected void getSprites() {
        // Load player sprites here
    }

    @Override
    protected void entityMove() {
        if (getGc().getKeyH().isUpPressed()) worldYPos -= velocity;
        else if (getGc().getKeyH().isDownPressed()) worldYPos += velocity;
        else if (getGc().getKeyH().isLeftPressed()) worldXPos -= velocity;
        else if (getGc().getKeyH().isRightPressed()) worldXPos += velocity;

        checkOutOfBounds();
//        collider.setLocation(worldXPos, worldYPos);
    }
    
    @Override
    protected void checkOutOfBounds() {
        if (worldXPos < 0) worldXPos = 0;
        if (worldYPos < 0) worldYPos = 0;
        if (worldXPos + collider.width > gameWidth) worldXPos = gameWidth - collider.width;
        if (worldYPos > gameHeight) worldYPos = gameHeight; // Allow worldYPos to reach gameHeight
    }


    @Override
    public void getCoordinates() {
        System.out.println("X: " + worldXPos + " Y: " + worldYPos);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillRect(worldXPos, worldYPos, collider.width, collider.height);
    }

    @Override
    public void update() {
        entityMove();
    }
}