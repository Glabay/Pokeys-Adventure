package org.game.entity.player;

import org.game.entity.Entity;
import org.game.handlers.InputManager;
import org.game.handlers.Movement;
import org.game.handlers.SpriteHandler;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Player extends Entity {

    Inventory inventory;
    PlayerSave playerSave;
    Skills skills;
    SpriteHandler sprites;
    Movement movement;
    
    InputManager inputManager;
    Animation PLAYER_MOVE_NORTH;
    Animation PLAYER_MOVE_SOUTH;
    Animation PLAYER_MOVE_WEST;
    Animation PLAYER_MOVE_EAST;
    
    int[] duration = {200, 200};
    public boolean INVENTORY = false;
    public boolean SKILLS = false;
    public boolean EQUIPMENT = false;

    public InputManager getInputManager() {
        return inputManager;
    }
    
    public Animation getAnimation(String dir) {
        switch(dir) {
            case "south":
                return PLAYER_MOVE_SOUTH;
            case "north":
                return PLAYER_MOVE_NORTH;
            case "east":
                return PLAYER_MOVE_EAST;
            case "west":
                return PLAYER_MOVE_WEST;
                default:
                    return PLAYER_MOVE_SOUTH;
        }
    }
    
    public Movement getMovement() {
        return movement;
    }
    
    public SpriteHandler getSprites() {
        return sprites;
    }
    
    public Inventory getInventory() {
        return inventory;
    }
    
    public PlayerSave getPlayerSave() {
        return playerSave;
    }
    
    public void init() throws SlickException {
        Image[] walkUp = {new Image("res/entity/player/pokeyB.png"), new Image("res/entity/player/pokeyB.png")};
        Image[] walkDown = {new Image("res/entity/player/pokeyF.png"), new Image("res/entity/player/pokeyF.png")};
        Image[] walkLeft = {new Image("res/entity/player/pokeyL.png"), new Image("res/entity/player/pokeyL.png")};
        Image[] walkRight = {new Image("res/entity/player/pokeyR.png"), new Image("res/entity/player/pokeyR.png")};

        PLAYER_MOVE_NORTH = new Animation(walkUp, duration, false);
        PLAYER_MOVE_SOUTH = new Animation(walkDown, duration, false);
        PLAYER_MOVE_WEST = new Animation(walkLeft, duration, false);
        PLAYER_MOVE_EAST = new Animation(walkRight, duration, false);
        AVATAR = PLAYER_MOVE_SOUTH;
    }

    public Player() throws SlickException {
        init();
        setHitpoints(10);
        setPlayerPos(320, 120);
        skills = new Skills();
        inventory = new Inventory();
        playerSave = new PlayerSave();
        inputManager = new InputManager();
        sprites = new SpriteHandler();
        movement = new Movement();
    }

    @Override
    public int getMaxHitpoints() {
        return skills.getLevel(Skills.HITPOINTS);
    }

    public Skills getSkills() {
        return skills;
    }
    
    public void update(Graphics gfx) {
        if (INVENTORY) {
            gfx.setColor(Color.black);
            gfx.fillRect(450, 0, 170, 200);
            gfx.setColor(Color.gray);
            gfx.fillRect(450, 0, 165, 20); // title box
            gfx.fillRect(450, 200, 165, 5); // bottom 
            gfx.fillRect(445, 0, 5, 205); // bourder
            gfx.fillRect(615, 0, 5, 205); // bourder
            gfx.setColor(Color.green);
            gfx.drawString("Inventory", 490, 0);
            if (!INVENTORY) {
                gfx.clear();
            }
        }
        if (EQUIPMENT) {
            gfx.setColor(Color.black);
            gfx.fillRect(450, 0, 170, 200);
            gfx.setColor(Color.gray);
            gfx.fillRect(450, 0, 165, 20); // title box
            gfx.fillRect(450, 200, 165, 5); // bottom 
            gfx.fillRect(445, 0, 5, 205); // bourder
            gfx.fillRect(615, 0, 5, 205); // bourder
            gfx.setColor(Color.green);
            gfx.drawString("Equipment", 490, 0);
            if (!EQUIPMENT) {
                gfx.clear();
            }
        }
        if (SKILLS) {
            gfx.setColor(Color.black);
            gfx.fillRect(450, 0, 170, 200);
            gfx.setColor(Color.gray);
            gfx.fillRect(450, 0, 165, 20); // title box
            gfx.fillRect(450, 200, 165, 5); // bottom 
            gfx.fillRect(445, 0, 5, 205); // bourder
            gfx.fillRect(615, 0, 5, 205); // bourder
            gfx.setColor(Color.green);
            gfx.drawString("Skills", 500, 0);
            gfx.setColor(Color.white);
            int line = 5;
            for (int i = 0; i < Skills.SKILL_NAME.length; i ++) {
                gfx.drawString(Skills.SKILL_NAME[i] + ": " + getSkills().level[i], 455, line += 15);
            }
            if (!SKILLS) {
                gfx.clear();
            }
        }
        
    }
}
