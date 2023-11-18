package org.game.handlers;

import org.game.entity.player.Player;
import org.game.states.States;
import org.game.states.World;
import org.game.states.maps.misc.Objects;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Michael Glabay
 * @since 26-Mar-2014
 */
public class Movement {

    public void handleMovement(Player player, GameContainer gc, StateBasedGame sbg, int i) {
        Input input = gc.getInput();
        //CollisionManager cm = new CollisionManager(player);
        /*
         * Move UP
         * Move the avatar in the north direction
         */
        if (input.isKeyDown(Input.KEY_UP)) {
            switch(World.getCurrentState()) {
                case States.POKEY_HOUSE:
                    if (World.getWorldY() >= Objects.BED[1]) {
                        if (World.WORLD_POS_X <= Objects.BED[0] && World.WORLD_POS_X >= Objects.BED[2]) {
                            World.WORLD_POS_Y -= i * 0.1f;
                        }
                    }
                    break;
                case States.POKEYVILLE_STATE:
                    break;
                default:
                    break;
            }
            setWalkDir(player, player.getAnimation("north"));
            World.WORLD_POS_Y += i * 0.1f;

        }

        /*
         * Move DOWN
         * Move the avatar in the south direction
         */
        if (input.isKeyDown(Input.KEY_DOWN)) {
            setWalkDir(player, player.getAnimation("south"));
            World.WORLD_POS_Y -= i * 0.1f;
        }

        /*
         * Move LEFT
         * Move the avatar in the west direction
         */
        if (input.isKeyDown(Input.KEY_LEFT)) {
            switch(World.getCurrentState()) {
                case States.POKEY_HOUSE:
                    if (World.getWorldX() >= Objects.BED[2]) {
                        if (World.WORLD_POS_Y >= Objects.BED[1] && World.WORLD_POS_Y <= Objects.BED[3]) {
                            World.WORLD_POS_X -= i * 0.1f;
                        }
                    }
                    break;
                case States.POKEYVILLE_STATE:
                    break;
                default:
                    break;
            }
            setWalkDir(player, player.getAnimation("west"));
            World.WORLD_POS_X += i * 0.1f;
        }

        /*
         * Move RIGHT
         * Move the avatar in the east direction
         */
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            switch(World.getCurrentState()) {
                case States.POKEY_HOUSE:
                    if (World.getWorldX() >= Objects.BED[0]) {
                        if (World.WORLD_POS_Y >= Objects.BED[1] && World.WORLD_POS_Y <= Objects.BED[3]) {
                            World.WORLD_POS_X += i * 0.1f;
                        }
                    }
                    break;
                case States.POKEYVILLE_STATE:
                    break;
                default:
                    break;
            }
            setWalkDir(player, player.getAnimation("east"));
            World.WORLD_POS_X -= i * 0.1f;
        }
    }

    private void setWalkDir(Player player, Animation walkDir) {
        player.AVATAR = walkDir;
    }
}
