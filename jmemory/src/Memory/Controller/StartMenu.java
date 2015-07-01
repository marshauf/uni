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

import Memory.View.Display;

/**
 * Controller code for initial player input before gamestart.
 * @author Marcel Hauf
 */
public class StartMenu {

    /**
     * Ask the amount of cards with which will be played.
     * @return Returns the amount of cards the player wants.
     */
    public int askCardAmount()
    {
        Display.printLine("How many cards should be given? (Enter a even number which is higher than two, please.)");

        int cardAmount = 1;
        while(cardAmount <= 2 || (cardAmount % 2) != 0) {
            String cardAmountStr= Input.readLine();
            try {
                cardAmount = Integer.parseInt(cardAmountStr);
            } catch (Exception e) {
                 // Continue asking
            }
            if(cardAmount <= 2 || (cardAmount % 2) != 0)
            {
                Display.printLine("Wrong input, sorry. Enter a even number which represents the amount of cards and is higher than two, please");
            }
        }
        return cardAmount;
    }

    /**
     * Ask the for a player name.
     * @param playerNumber
     * @return Returns a player name.
     */
    public String askPlayerName(int playerNumber) {
        Display.printLine("Enter the name of player" + playerNumber + ", please.");
        String player = "";
        while(player.length() <= 0) {
            player = Input.readLine();
            if(player.length() <= 0) {
                Display.printLine("You need to enter at least one character.");
                Display.printLine("Enter the name of player" + playerNumber + ", please.");
            }
        }
        return player;
    }
}
