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

import Memory.Model.*;
import java.util.List;

/**
 * The Display class handles all View code related processes like printing to the console.
 * @author Marcel Hauf
 */
public class Display {
    private PlayField playfield;

    /**
     * Constructs the Display.
     * @param playfield Contains informations used by the Display.
     */
    public Display(PlayField playfield) {
        this.playfield = playfield;
    }

    /**
     * Views statistic by printing informations about the game to the console.
     */
    public void viewStatistic() {
        String text = "\n";
        text += playfield.getCurrentPlayer().toString() + " turn.\n";
        text += "Statistic:\n";
        text += "Neutral cards: " + playfield.remainingCards() + "\n";
        text += playfield.getPlayerOne().getName() + ": " + playfield.getPlayerOne().getPoints() + "\n";
        text += playfield.getPlayerTwo().getName() + ": " + playfield.getPlayerTwo().getPoints() + "\n";
        System.out.print(text);
    }

    /**
     * Views the current play field by printing it to the console.
     */
    public void viewPlayField() {
        //viewPlayField View
        String text = "";

        int i = 0;
        List<Card> cards = playfield.getCards();
        for(Card c : cards)
        {
            if(i != c.getPosition().X())
            {
                text += "\n";
//                for(int j = 0; j < playfield.getWidth(); j++)
//                {
//                    text += "■■■■■";
//                }
                i++;
            }
            if(c.isVisible()) {
                text += " " + c.getID();
            } else {
                text += " xx";
            }
        }
        text += "\n";
        System.out.print(text);
    }

    /**
     * Prints text to console.
     * @param text Printed text.
     */
    public static void printLine(String text) {
        System.out.println(text);
    }

    /**
     * Views end game by printing the statistic, playfield and the winner to the console.
     * @param winner The player who won.
     */
    public void viewEndGame(Owner winner) {
        viewStatistic();
        viewPlayField();
        if(winner == Owner.Neutral) {
            printLine("There is no winner. Both players have the same amount of cards.");
        } else {
            printLine("The winner is " + winner.toString());
        }
    }
}
