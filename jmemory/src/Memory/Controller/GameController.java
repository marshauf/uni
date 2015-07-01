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

import Memory.Model.Card;
import Memory.Model.Owner;
import Memory.Model.PlayField;
import Memory.Model.Player;
import Memory.Model.Position;
import Memory.View.Display;
/**
 * GameController is the main class of the Controller.
 * @author Marcel Hauf
 */
public class GameController {
    // Model
    private PlayField playField;
    // View
    private Display display;

    // Controller
    private StartMenu startMenu;
    private int cardAmount;
    private boolean ingame;
    private Player player1;
    private Player player2;

    /**
     * Constructor of GameController.
     */
    public GameController() {
        startMenu = new StartMenu();
    }

    /**
     * Calls methods to get the initial variables from the players before the game starts.
     */
    public void getPlayerInput() {
        Display.printLine("Welcome to JMemory a memory game for two players.\n");
        
        cardAmount = startMenu.askCardAmount();
        player1 = new Player(startMenu.askPlayerName(1), 1);
        player2 = new Player(startMenu.askPlayerName(2), 2);
    }

    /**
     * Starts the game.
     */
    public void start()
    {
        playField = new PlayField(cardAmount, player1, player2);
        display = new Display(playField);
        ingame = true;
        playField.setCurrentPlayer(Owner.Player1);
        while(ingame) {
            update();
        }
    }

    /**
     * Updates Controller, Model and View.
     */
    private void update() {
        playField.Update();
        display.viewStatistic();
        display.viewPlayField();
        
        if(playField.remainingCards() == 0) {
            if(player1.getPoints() > player2.getPoints()) {
                display.viewEndGame(Owner.Player1);
            } else if(player2.getPoints() > player1.getPoints()) {
                display.viewEndGame(Owner.Player2);
            } else {
                display.viewEndGame(Owner.Neutral);
            }
            ingame = false; // Game over
        } else {
            if(playField.getCurrentPlayer() == Owner.Player1) {
                playField.setCurrentPlayer(Owner.Player2);
                playRound(1);                
            } else {
                playField.setCurrentPlayer(Owner.Player1);
                playRound(2);
            }
        }
    }

    // playes one round, collects input calls Model and View methods.
    private void playRound(int playerNum) {
        Display.printLine(playField.getPlayerName(playerNum) + " your turn.");
        Display.printLine("Enter the first card you want to look up.");
        Card card1 = getCardInput();
        display.viewPlayField();

        Display.printLine("Enter the second card you want to look up.");
        Card card2 = getCardInput();
        display.viewPlayField();

        if(!card1.compareID(card2)) {
            Display.printLine("Cards are not even.");
            card1.setVisible(false);
            card2.setVisible(false);
        } else {
            card1.setOwner(this.playField.getCurrentPlayer());
            card2.setOwner(this.playField.getCurrentPlayer());
        }
    }

    /**
     * Gets player input from current player.
     */
    private Card getCardInput() {
        boolean correctInput = false;
        Card card = null;
        while(!correctInput) {
            String input = Input.readLine();
            Position pos = Position.getPositionFromString(input);
            if(pos == null) {
                Display.printLine("Wrong input. Enter two numbers which represents the position of the cards starting with 0.");
                continue; // Repeat input
            }
            card = playField.getCard(pos);
            if(card == null) {
                Display.printLine("The card at this position does not exist.");
            } else if(card.isVisible()) {
                Display.printLine("Card is allready looked up. Please type in a new one.");
            } else {
                correctInput = true;
                card.setVisible(true); // Set card visible
            }
        }
        return card;
    }
}