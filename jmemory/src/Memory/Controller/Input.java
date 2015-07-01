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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The input class holds methods to get data from the console.
 * @author Marcel Hauf
 */
public class Input {
    /**
     * Reads one line from the console.
     * @return Returns one line from the console.
     */
    public static String readLine() {
        InputStreamReader inStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inStream);
        String line = "";
        try {
            line = reader.readLine();
        } catch (IOException ex) {
            // This should never happen
            Display.printLine(ex.getMessage() + "\n Im sorry this should not happen.");
        }
        return line;
    }
}
