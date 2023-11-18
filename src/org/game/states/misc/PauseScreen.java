package org.game.states.misc;

import org.game.content.Misc;
import org.game.handlers.SpriteHandler;
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
 * @since 2-Oct-2013
 */
public class PauseScreen extends BasicGameState {

    boolean inventory = false;

    public PauseScreen(int state) {
    }

    @Override
    public int getID() {
        return States.PAUSE_SCREEN;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics gfx) throws SlickException {
        SpriteHandler.getPauseMenu().draw(0, 0);
        gfx.setColor(Color.white);
        gfx.drawString("PAUSED", 320, 160);
        gfx.setColor(Color.lightGray);
        gfx.fillRect(10, 50, 73, 36);
        gfx.fillRect(10, 100, 90, 36);
        gfx.fillRect(10, 150, 90, 36);
        gfx.fillRect(10, 200, 90, 36);
        gfx.setColor(Color.white);
        gfx.drawString("Resume", 15, 60);
        gfx.drawString("Main menu", 15, 110);
        gfx.drawString("Quit game", 15, 160);
        gfx.drawString("Options", 15, 210);
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
                gc.setPaused(false);
                sbg.enterState(States.POKEY_HOUSE);
            }
        }
        if ((posX > 10 && posX < 102) && (posY > 266 && posY < 300)) {
            if (Mouse.isButtonDown(0)) {
                gc.setPaused(false);
                sbg.enterState(States.MAIN_MENU);
            }
        }
        if ((posX > 10 && posX < 100) && (posY > 215 && posY < 245)) {
            if (Mouse.isButtonDown(0)) {
                System.exit(0);
            }
        }
        if ((posX > 10 && posX < 100) && (posY > 165 && posY < 200)) {
            if (Mouse.isButtonDown(0)) {
                gc.setPaused(false);
                sbg.enterState(States.OPTION_STATE);
            }
        }
    }
}
