package org.game.entity;

import org.newdawn.slick.Animation;

/**
 *
 * @author Michael Glabay
 * @since 14-Oct-2013
 */
public abstract class Entity {

    private int hitpoints;
    private float posX;
    private float posY;
    public transient int direction;
    public transient Entity attackedBy;
    public transient Animation AVATAR;
    
    public abstract int getMaxHitpoints();
    
    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }
    
    public void setPlayerPos(float x, float y) {
        posX = x;
        posY = y;
    }
    
    public Animation getAvatar() {
        return AVATAR;
    }
    
    public int getHitpoints() {
        return hitpoints;
    }
    
    public float getPosX() {
        return posX;
    }
    
    public float getPosY() {
        return posY;
    }
    
    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
    
    public Entity getAttackedBy() {
        return attackedBy;
    }

    public void setAttackedBy(Entity attackedBy) {
        this.attackedBy = attackedBy;
    }
    
    public void resetCombat() {
        attackedBy = null;
    }
}
