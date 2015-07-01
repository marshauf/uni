//     The contents of this file are subject to the Mozilla Public License
//     Version 1.1 (the "License"); you may not use this file except in
//     compliance with the License. You may obtain a copy of the License at
//     http://www.mozilla.org/MPL/
//
//     Software distributed under the License is distributed on an "AS IS"
//     basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
//     License for the specific language governing rights and limitations
//     under the License.
//
//     The Original Code is AgateLib.
//
//     The Initial Developer of the Original Code is Marcel Hauf.
//     Portions created by Marcel Hauf are Copyright (C) 2010.
//     All Rights Reserved.
//
//     Contributor(s): Marcel Hauf

package Memory.Controller;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests Controller related code.
 * @author Marcel Hauf
 */
public class ControllerTest {
    GameController controller;

    /**
     * Pseudo test of the GameController class.
     */
    @Test
    public void testGameController() {
        controller = new GameController();
        //controller.getPlayerInput();
        //controller.start();
    }

    /**
     * Tests the Input class.
     */
    @Test
    public void testInput() {
        String input = Input.readLine();
        assertNull(input);
    }

    /**
     * Pseudo test of the StartMenu class.
     */
    @Test
    public void testStartMenu() {
        StartMenu startMenu = new StartMenu();
        //startMenu.askCardAmount();
        //startMenu.askPlayerName(0);
    }
}
