package org.game.states.shops;

import org.game.states.States;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Michael Glabay
 * @since 7-Oct-2013
 */
public class GeneralShop extends BasicGameState {

    public GeneralShop(int state) {
    }

    @Override
    public int getID() {
        return States.SHOP_STATE;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics gfx) throws SlickException {
        gfx.drawString("Welcome to the general store", 200, 5);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
    }
}