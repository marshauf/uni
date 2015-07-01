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

package Memory.View;

import Memory.Model.Owner;
import Memory.Model.PlayField;
import Memory.Model.Player;
import org.junit.Test;

/**
 * ViewTest contains JUnit tests for the View code.
 * @author marcel
 */
public class ViewTest {
    Player player1 = new Player("player1", 1);
    Player player2 = new Player("player2", 2);

    PlayField playfield = new PlayField(10, player1, player2);

    /**
     * Tests the Display class.
     */
    @Test
    public void testDisplay() {
        Display display = new Display(playfield);
        Display.printLine("test");
        display.viewStatistic();
        display.viewPlayField();
        display.viewEndGame(Owner.Player1);
    }
}