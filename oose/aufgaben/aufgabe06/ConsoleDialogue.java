package name.panitz.oose13.dialogue;

import java.io.*;

public class ConsoleDialogue {
	final ButtonLogic logic;
	
	public ConsoleDialogue(ButtonLogic logic) {
		this.logic = logic;
	}

	public void run() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		do {
			try {
				System.out.println(logic.getDescription() + "\n(Ende mit 'good bye ')");
				String command = in.readLine();
				if (command.equals("good bye")) break;
				System.out.println(logic.eval(command));
			} catch(IOException ex) {
				System.out.println(ex);
			}
		} while(true);
	}
	
	public static void main(String[] args) {
		new ConsoleDialogue(new ButtonLogic()).run();
	}
}