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
 * Represents a player with name, a player number and the points.
 * @author Marcel Hauf
 */
public class Player {
    private String name;
    private int number;
    private int points = 0;

    /**
     * Gets player points.
     * @return Returns player points.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets player points.
     * @param points New player points.
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Gets the player name.
     * @return Returns player name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the player number.
     * @return Returns player number.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Constructor of Player.
     * @param name The players name.
     * @param number The player number.
     */
    public Player(String name, int number) {
        this.name = name;
        this.number = number;
    }
}