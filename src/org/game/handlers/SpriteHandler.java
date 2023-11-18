package org.game.handlers;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Michael Glabay
 * @since 19-Oct-2013
 */
public class SpriteHandler {

     static Image POKEY_HOUSE;
     static Image POKEY_VILLE;
     static Image PAUSE_MENU;
     static Image WORLD_MAP;
     
    public SpriteHandler() throws SlickException {
        init();
    }
    
    public void init() throws SlickException {
        
        PAUSE_MENU = new Image("res/maps/pauseScreen.png");
        
        POKEY_HOUSE = new Image("res/maps/PokeyHouse.png");
        POKEY_VILLE = new Image("res/maps/homeMap.png");
        WORLD_MAP = new Image("res/maps/worldMap.png");
    }
    
    public static Image getPokeyHouse() {
        return POKEY_HOUSE;
    }
    
    public static Image getPauseMenu() {
        return PAUSE_MENU;
    } 
    
    public static Image getWorldMap() {
        return WORLD_MAP;
    }
    
    public static Image getPokeyVilleMap() {
        return POKEY_VILLE;
    }
    
}
