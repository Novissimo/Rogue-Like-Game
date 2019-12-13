package rltut.screens;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {
	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.write("Cave Jam", 1, 1);
		terminal.writeCenter("-- press [enter] to jam --", 22);
	}
	
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
		
	}

}
