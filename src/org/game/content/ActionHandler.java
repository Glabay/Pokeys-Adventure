package org.game.content;

import org.game.states.States;
import org.game.states.World;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Michael Glabay
 * @since 13-Mar-2014
 */
public class ActionHandler {

    public void handleActionEvent(StateBasedGame sbg) {
        if (World.getCurrentState() == States.POKEY_HOUSE) {
            if (World.WORLD_POS_X > 30 && World.WORLD_POS_X < 60) {
                if (World.WORLD_POS_Y <= -340) {
                    new World(States.POKEYVILLE_STATE, -350, -495);
                    sbg.enterState(States.POKEYVILLE_STATE);
                }
            }
        }
    }
}
