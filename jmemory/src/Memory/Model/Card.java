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

/**
 * The card class stores informations about one card.
 * Like the ID, the owner and the position of the card.
 * @author Marcel Hauf
 */
public class Card {
    private String id;
    private boolean visible = false;
    private Position position;
    private Owner owner = Owner.Neutral;

    /**
     * Gets owner of the card.
     * @return Returns the owner.
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * Sets owner by number.
     * Player one is 1.
     * Player two is 2.
     * Default is Neutral.
     * @param num Owner number.
     */
    public void setOwnerNum(int num) {
        switch(num) {
            case 0:
                owner = Owner.Neutral;
                break;
            case 1:
                owner = Owner.Player1;
                break;
            case 2:
                owner = Owner.Player2;
                break;
            default:
                owner = Owner.Neutral;
                break;
        }
    }

    /**
     * Sets card owner.
     * @param owner Card owner.
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * Gets the ID of the card.
     * @return Return card ID.
     */
    public String getID() {
        return id;
    }

    /**
     * Checks visible state.
     * @return Returns visible state.
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Sets the visible state of this card.
     * @param value
     */
    public void setVisible(boolean value) {
        visible = value;
    }

    /**
     * Gets position of the card.
     * @return Return position.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Constructor of Card.
     * @param id Card ID.
     * @param position Position of the card.
     */
    public Card(String id, Position position) {
        this.id = id;
        this.position = position;
    }

    /**
     * Compares the position of this card with a given position.
     * @param pos Position to be compared.
     * @return Return true if the positions are equal in there values.
     */
    public boolean comparePosition(Position pos) {
       return this.position.equals(pos);
    }

    /**
     * Compares the ID of this card with another card.
     * @param card The second card.
     * @return Return true if the card IDs match.
     */
    public boolean compareID(Card card) {
        return id.matches(card.id);
    }
}
