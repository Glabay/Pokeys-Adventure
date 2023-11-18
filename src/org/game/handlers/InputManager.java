package org.game.handlers;

/**
 *
 * @author Michael Glabay
 * @since 9-Oct-2013
 */
public class InputManager {

    Keyboard keyboard;
    Mouse mouse;
    ControlerHandler controler;
    
    public InputManager() {
        keyboard = new Keyboard();
        mouse = new Mouse();
        controler = new ControlerHandler();
    }
    
    public ControlerHandler getControlerHandler() {
        return controler;
    }
    
    public Mouse getMouseHandler() {
        return mouse;
    }
    
    public Keyboard getKeyboardHandler() {
        return keyboard;
    }
}
