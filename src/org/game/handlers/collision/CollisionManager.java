package org.game.handlers.collision;

import org.game.entity.player.Player;
import org.game.states.World;

/**
 *
 * @author Michael Glabay
 * @since 28-Oct-2013
 */
public class CollisionManager {

    Player player;
    private float x = World.WORLD_POS_X;
    private float y = World.WORLD_POS_Y;

    public CollisionManager(Player player) {
        this.player = player;
    }
}
