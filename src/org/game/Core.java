package org.game;

import org.game.content.Misc;
import org.game.states.States;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Michael Glabay
 * @since 2-Oct-2013
 */
public class Core extends StateBasedGame {
    
    public Core(String name) {
        super(name);
        new States().loadStates(this);
    }
    
    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(States.MAIN_MENU).init(gc, this);
        this.getState(States.POKEY_HOUSE).init(gc, this);
        this.getState(States.PAUSE_SCREEN).init(gc, this);
        this.getState(States.SHOP_STATE).init(gc, this);
        
        this.enterState(States.MAIN_MENU);
    }
    
    public static void main(String[] args) {
        AppGameContainer appgc;
        try {
            appgc = new AppGameContainer(new Core(Misc.GAME_NAME));
            appgc.setTargetFrameRate(49);
            appgc.setDisplayMode(640, 400, false);
            appgc.start();
        } catch (SlickException se) {
        }
    }

}
