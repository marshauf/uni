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
 * Position stores a two dimensional point.
 * @author Marcel Hauf
 */
public class Position {
    private int x;
    private int y;

    /**
     * Gets the X position.
     * @return Returns the X position.
     */
    public int X() {
        return x;
    }

    /**
     * Sets the X position.
     * Only positive values are accepted.
     * @param value X position.
     */
    public void X(int value) {
        if(value >= 0)
            this.x = value;
        else
            this.x = 0;
    }

    /**
     * Gets Y position.
     * @return Returns the Y position.
     */
    public int Y() {
        return y;
    }

    /**
     * Sets the Y position.
     * Only positive values are accepted.
     * @param value Y position.
     */
    public void Y(int value) {
        if(value >= 0)
            this.y = value;
        else
            this.y = 0;
    }

    /**
     * Constructor for Position.
     * @param x The X position.
     * @param y The Y posititon.
     */
    public Position(int x, int y) {
        X(x);
        Y(y);
    }

    /**
     * Parses a position from a string.
     * Each dimension is seperated by a blank.
     * Only positive numbers are parsed.
     * On error or no match returns null.
     * @param input A string which contains the raw position.
     * @return Returns a position with positve numbers or null on an error or wrong input.
     */
    public static Position getPositionFromString(String input) {
        try {
            int x = Integer.parseInt(input.split(" ")[0]);
            int y = Integer.parseInt(input.split(" ")[1]);
            if(x >= 0 && y >= 0) {
                return new Position(x, y);
            } else {
                return null;
            }
        } catch(Exception e) {
            return null;
        }
    }

    /**
     * Compares this Position with another position.
     * Only the values are compared not the hash.
     * @param pos Position to compare.
     * @return Returns true if the values are equal.
     */
    public boolean equals(Position pos) {
        if(X() == pos.X() && Y() == pos.Y()) {
            return true;
        } else {
            return false;
        }
    }
}
