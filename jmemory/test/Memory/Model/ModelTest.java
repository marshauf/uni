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

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * ModelTest contains JUnit tests which test the Model code.
 * @author Marcel Hauf
 */
public class ModelTest {

    Player player1 = new Player("player1", 1);
    Player player2 = new Player("player2", 2);

    PlayField playfield = new PlayField(10, player1, player2);

    /**
     * Tests PlayField class.
     */
    @Test
    public void testPlayfield()
    {
        assertEquals(playfield.getPlayerOne(), player1);
        assertEquals(playfield.getPlayerTwo(), player2);

        assertNotNull(playfield.getHeight());
        assertNotNull(playfield.getWidth());

        assertEquals(5, playfield.getHeight());
        assertEquals(2, playfield.getWidth());

        playfield = new PlayField(100, player1, player2);
        assertEquals(10, playfield.getHeight());
        assertEquals(10, playfield.getWidth());

        // Set the owner of two cards to player1
        playfield.getCards().get(0).setOwner(Owner.Player1);
        playfield.getCards().get(1).setOwner(Owner.Player1);
        playfield.Update();
        assertEquals(1, player1.getPoints());
        assertEquals(98, playfield.remainingCards()); //Since two cards are owned by player1

        playfield.setCurrentPlayer(Owner.Player1);
        assertEquals(Owner.Player1, playfield.getCurrentPlayer());

        Position tempPos = playfield.getCards().get(0).getPosition();
        assertEquals(playfield.getCard(tempPos), playfield.getCards().get(0));

        assertEquals("player1", playfield.getPlayerName(1));
    }

    /**
     * Tests Player class.
     */
    @Test
    public void testPlayer()
    {
        assertNotNull(player1.getName());
        assertNotNull(player2.getName());
        assertEquals("player1", player1.getName());
        assertEquals("player2", player2.getName());
        assertEquals(1, player1.getNumber());
        assertEquals(2, player2.getNumber());
        
        int points = 20;
        player1.setPoints(points);
        assertEquals(points, player1.getPoints());
    }

    /**
     * Tests Card class.
     */
    @Test
    public void testCard()
    {
        Card card1 = new Card("0", new Position(1, 1));
        Card card2 = new Card("0", new Position(1, 2));

        assertTrue(card1.comparePosition(new Position(1, 1)));
        assertTrue(card1.compareID(card2));
        assertEquals(Owner.Neutral, card1.getOwner());

        card2.setOwnerNum(2);
        assertEquals(Owner.Player2, card2.getOwner());

        card1.setOwner(Owner.Player1);
        assertEquals(Owner.Player1, card1.getOwner());

        assertEquals(card1.getID(), card2.getID());
        assertNotSame(card1.getPosition(), card2.getPosition());
        assertNotNull(card1.isVisible());
        
        assertNotNull(card2.isVisible());
        card2.setVisible(true);
        assertTrue(card2.isVisible());
    }

    /**
     * Tests Position class.
     */
    @Test
    public void testPosition()
    {
        Position pos1 = new Position(1, 1);
        Position pos11 = Position.getPositionFromString("1 1");

        assertTrue(pos1.equals(pos11));

        pos1.X(2);
        pos1.Y(4);
        assertEquals(2, pos1.X());
        assertEquals(4, pos1.Y());
    }
}