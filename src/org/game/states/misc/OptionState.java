package org.game.states.misc;

import org.game.content.Misc;
import org.game.states.States;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Michael Glabay
 * @since 11-Mar-2014
 */
public class OptionState extends BasicGameState {
    
    public OptionState(int ID) {
        
    }

    @Override
    public int getID() {
        return States.OPTION_STATE;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics gfx) throws SlickException {
        gfx.setColor(Color.lightGray);
        gfx.fillRect(10, 50, 73, 36);
        gfx.fillRect(10, 100, 110, 36);
        gfx.setColor(Color.white);
        gfx.drawString("Back", 15, 60);
        gfx.drawString("Fullscreen", 15, 110);
        gfx.drawString(Misc.MOUSE_POS, Misc.MOUSE_X, Misc.MOUSE_Y);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        if (Mouse.isInsideWindow()) {
            Misc.MOUSE_POS = "X:" + posX + " Y:" + posY;
        } else {
            Misc.MOUSE_POS = "";
        }
                
        if ((posX > 10 && posX < 80) && (posY > 315 && posY < 345)) {
            if (Mouse.isButtonDown(0)) {
                sbg.enterState(States.PAUSE_SCREEN);
            }
        }
        
        if ((posX > 10 && posX < 102) && (posY > 266 && posY < 300)) {
            if (Mouse.isButtonDown(0)) {
                gc.setFullscreen(toggleFullScreen(gc));
            }
        }
    }

    
    private boolean toggleFullScreen(GameContainer gc) {
        if (gc.isFullscreen()) {
            return false;
        } else if (!gc.isFullscreen()) {
            return true;
        }
        return toggleFullScreen(gc);
    }
}
