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

package Memory.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * PlayField stores most of the Model related values.
 * @author Marcel Hauf
 */
public class PlayField {
    private List<Card> cards = new ArrayList<Card>();

    private Player playerOne = null;
    private Player playerTwo = null;
    
    private Owner currentPlayer = Owner.Neutral;

    private int remainingCards = 0;

    private int height = 0;
    private int width = 0;

    /**
     * Gets player on turn.
     * @return Returns current active playing player.
     */
    public Owner getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Sets the active player who has the turn.
     * @param player Active player.
     */
    public void setCurrentPlayer(Owner player) {
        currentPlayer = player;
    }

    /**
     *
     * @return Returns all cards which are on the playfield.
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Gets specific card via position.
     * @param pos Position to look up to get card.
     * @return Returns card from position.
     */
    public Card getCard(Position pos) {
        for(Card c : cards) {
            if(c.comparePosition(pos)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Gets the play field height.
     * @return Returns height of the playfield.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the play field width.
     * @return Returns width of the playfield.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets player one.
     * @return Returns player one.
     */
    public Player getPlayerOne() {
        return playerOne;
    }

    /**
     * Gets player two.
     * @return Returns player two.
     */
    public Player getPlayerTwo() {
        return playerTwo;
    }

    /**
     * Gets the player name.
     * @param playerNumber
     * @return Returns the name of the player.
     */
    public String getPlayerName(int playerNumber) {
        // 2 player limited code
        switch(playerNumber) {
            case 1:
                return playerOne.getName();
            case 2:
                return playerTwo.getName();
            default:
                return null;
        }
    }

    /**
     * Gets remaining cards which are not visible.
     * @return Returns the amount of remaining invisible cards.
     */
    public int remainingCards() {
        return this.remainingCards;
    }

    /**
     * Constructor of PlayField.
     * @param cards Amount of cards to play with.
     * @param playerOne Player one.
     * @param playerTwo Player two.
     */
    public PlayField(int cards, Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        generatePlayfield(cards);        
    }

    /**
     * Updates the playfield by calculating statistics.
     */
    public void Update() {
        // Calculate statistic
        int neutralCards = 0;
        int player1Cards = 0;
        int player2Cards = 0;

        for(Card c : cards) {
            switch(c.getOwner()) {
                case Neutral:
                    neutralCards++;
                    break;
                case Player1:
                    player1Cards++;
                    break;
                case Player2:
                    player2Cards++;
                    break;
            }
        }
        // Assign points to player and save remaining card amount
        playerOne.setPoints(player1Cards/2);
        playerTwo.setPoints(player2Cards/2);
        this.remainingCards = neutralCards;
    }

    /**
     * Generates a playfield with specified amount of cards.
     * @param cardNums Number of cards.
     */
    private void generatePlayfield(int cardNums)
    {
        // Compute and save width and height
        this.width = computeHeigth(cardNums);
        this.height = cardNums/this.width;

        // Generate ids for cards
        List<String> ids = new ArrayList<String>();
        for(int i = 0; i < this.width * this.height/2; i++) {
            ids.add(Integer.toString(i));
        }
        ids.addAll(ids);

        Random ran = new Random();
        String id = "";
        int index = 0;

        // Add cards with random assigned ids from generated list of ids
        for(int i = 0; i < this.width; i++) {
            for(int j = 0; j < this.height; j++) {
                index = ran.nextInt(ids.size());
                id = ids.get(index);
                cards.add(new Card(id, new Position(i, j)));
                ids.remove(index);
            }
        }
    }

    /**
     * Computes the heigth of the playfield.
     * @param cards The amount of cards.
     * @return Returns the heigth of the playfield.
     */
    private int computeHeigth(int cards)
    {
        int root = (int) Math.pow((double)cards, 0.5D);
        if(root * root == cards) {
            return root;
        }
        int sizeX = 2;
        int i = 2;
        while(i < cards/2 && (i * sizeX) != cards)
        {
            if((cards % i) == 0)
            {
                sizeX = i;
            }
            i++;
        }
        return sizeX;
    }
}