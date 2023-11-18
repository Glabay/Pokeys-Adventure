package org.game.states.misc;

import org.game.content.Misc;
import org.game.states.States;
import org.game.states.World;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Michael Glabay
 * @since 2-Oct-2013
 */
public class MainMenu extends BasicGameState {

    public Image PLAY_BUTTON, EXIT_BUTTON;
    public String mousePos = "";
    private final int stateID;

    public MainMenu(int state) {
        stateID = state;
    }

    @Override
    public int getID() {
        return stateID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        PLAY_BUTTON = new Image("res/buttons/playNow.png");
        EXIT_BUTTON = new Image("res/buttons/exitGame.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics gfx) throws SlickException {
        gfx.drawString("Welcome to " + Misc.GAME_NAME, 200, 50);
        PLAY_BUTTON.draw(100, 200);
        EXIT_BUTTON.draw(100, 250);
        gfx.drawString(Misc.MOUSE_POS, Misc.MOUSE_X, Misc.MOUSE_Y);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        Misc.MOUSE_POS = "X:" + posX + " Y:" + posY;

        /*
         * Play Now
         * If the user clicks on the Play button
         * Open the GameScreen
         */
        if ((posX > 100 && posX < 300) && (posY > 160 && posY < 200)) {
            if (Mouse.isButtonDown(0)) {
                NewGame(sbg);
            }
        }

        /*
         * Exit Game
         * If the user clicks on the Exit button
         * Close the game out
         */
        if ((posX > 100 && posX < 300) && (posY > 110 && posY < 145)) {
            if (Mouse.isButtonDown(0)) {
                System.exit(0);
            }
        }
    }

    private void LoadGame(StateBasedGame sbg) {
        
    }
    
    private void NewGame(StateBasedGame sbg) {
        
        new World(States.POKEY_HOUSE, 240, 62);
        sbg.enterState(States.POKEY_HOUSE);
    }
}
