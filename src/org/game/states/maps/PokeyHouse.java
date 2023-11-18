package org.game.states.maps;

import org.game.entity.player.Player;
import org.game.handlers.SpriteHandler;
import org.game.states.States;
import org.game.states.World;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Michael Glabay
 * @since 2-Oct-2013
 */
public class PokeyHouse extends BasicGameState {

    Player player;
    public String avatarPos = "";
    public String interactionString = "";

    public PokeyHouse(int state) {
    }

    @Override
    public int getID() {
        return States.POKEY_HOUSE;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        player = new Player();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics gfx) throws SlickException {
        SpriteHandler.getPokeyHouse().draw(World.getWorldX(), World.getWorldY());
        player.getAvatar().draw(player.getPosX(), player.getPosY());
        gfx.setColor(Color.white);
        gfx.drawString(avatarPos, 10, 350);
        gfx.drawString(interactionString, 10, 50);

        player.update(gfx);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        avatarPos = "X:" + World.WORLD_POS_X + " Y:" + World.WORLD_POS_Y;
        if (Mouse.isInsideWindow()) {
            interactionString = "X:" + getMX() + "\nY:" + getMY();
        } else {
            interactionString = "";
        }
        /*
         * Handle all keyboard interactions
         */
        player.getInputManager().getKeyboardHandler().handleKeyboardCommands(player, gc, sbg, i);
        
        if ((World.getWorldY() - player.getPosY()) >= 0xfffffffb) {
            World.WORLD_POS_Y -= i * 0.1f;
        }

        if ((World.getWorldX() - player.getPosX()) >= 0x0) {
            World.WORLD_POS_X -= i * 0.1f;
        }

        if (World.getWorldX() <= 0xffffff1c) {
            World.WORLD_POS_X += i * 0.1f;
        }
        if ((World.getWorldY()) <= 0xfffffea5) {
            World.WORLD_POS_Y += i * 0.1f;
        }
    }

    private int getMX() {
        return Mouse.getX();
    }

    private int getMY() {
        return Mouse.getY();
    }
    
}
