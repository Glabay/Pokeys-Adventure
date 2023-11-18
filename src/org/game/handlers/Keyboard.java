package org.game.handlers;

import org.game.content.ActionHandler;
import org.game.entity.player.Player;
import org.game.states.States;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Michael Glabay
 * @since 9-Oct-2013
 */
public class Keyboard {

    public void handleKeyboardCommands(Player player, GameContainer gc, StateBasedGame sbg, int i) {
        Input input = gc.getInput();
        player.getMovement().handleMovement(player, gc, sbg, i);
        
        if (input.isKeyPressed(HotkeyHandler.INVENTORY_KEY)) {
            if (!player.INVENTORY) {
                player.EQUIPMENT = false;
                player.SKILLS = false;
                player.INVENTORY = true;
            } else {
                player.INVENTORY = false;
            }
        }
        if (input.isKeyPressed(HotkeyHandler.EQUIPMENT_KEY)) {
            if (!player.EQUIPMENT) {
                player.INVENTORY = false;
                player.SKILLS = false;
                player.EQUIPMENT = true;
            } else {
                player.EQUIPMENT = false;
            }
        }
        if (input.isKeyPressed(HotkeyHandler.SKILL_KEY)) {
            if (!player.SKILLS) {
                player.INVENTORY = false;
                player.EQUIPMENT = false;
                player.SKILLS = true;
            } else {
                player.SKILLS = false;
            }
        }

        /*
         * Action Button
         * Performs the general interaction of the player
         */
        if (input.isKeyPressed(HotkeyHandler.ACTION_KEY)) {
            ActionHandler action = new ActionHandler();
            action.handleActionEvent(sbg);
        }

        /*
         * SpaceBar
         * Opens the pause menu
         */
        if (input.isKeyPressed(HotkeyHandler.PAUSE_MENU_KEY)) {
            gc.setPaused(true);
            sbg.enterState(States.PAUSE_SCREEN);
        }
    }
}
