package org.game.states;

import org.game.states.maps.PokeyHouse;
import org.game.states.maps.PokeyVille;
import org.game.states.maps.WorldMap;
import org.game.states.misc.MainMenu;
import org.game.states.misc.OptionState;
import org.game.states.misc.PauseScreen;
import org.game.states.shops.GeneralShop;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Michael Glabay
 * @since 2-Oct-2013
 */
public class States {
    
    public static final int MAIN_MENU = 0;
    public static final int POKEY_HOUSE = 1;
    public static final int PAUSE_SCREEN = 2;
    public static final int SHOP_STATE = 3;
    public static final int OPTION_STATE = 4;
    public static final int POKEYVILLE_STATE = 5;
    public static final int WORLD_MAP = 6;
    
    public void loadStates(StateBasedGame sbg) {
        sbg.addState(new MainMenu(MAIN_MENU));
        sbg.addState(new PokeyHouse(POKEY_HOUSE));
        sbg.addState(new PauseScreen(PAUSE_SCREEN));
        sbg.addState(new GeneralShop(SHOP_STATE));
        sbg.addState(new OptionState(OPTION_STATE));
        sbg.addState(new PokeyVille(POKEYVILLE_STATE));
        sbg.addState(new WorldMap(WORLD_MAP));
    }

}
