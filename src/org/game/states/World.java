package org.game.states;

/**
 * @author Michael Glabay
 * @since 14-Oct-2013
 */
public class World {

    
    public static float WORLD_POS_X;
    public static float WORLD_POS_Y;
    private static int CURRENT_STATE;
    
    public World(int state, int x, int y) {
        CURRENT_STATE = state;
        WORLD_POS_X = x;
        WORLD_POS_Y = y;
        init();
    }
    
    public void init() {
    }
    
    public static float getWorldX() {
        return WORLD_POS_X;
    }
    
    public static float getWorldY() {
        return WORLD_POS_Y;
    }
    
    public static void setWorldX(float x) {
        WORLD_POS_X = x;
    }
    
    public static int getCurrentState() {
        return CURRENT_STATE;
    }
    
}
