package PartnerCodeInHerePlease;

import java.awt.Graphics2D;

import SimonAfsana.ProgressInterfaceAfsana;
import gui.components.Component;

public class Progress extends Component implements ProgressInterfaceAfsana {
	
	public static final int height = 120;
	public static final int width = 120;

	public boolean gameOver;
	public String round;
	public String sequence;
	
	public Progress() {
		super(85, 85, width, height);
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub

	}
	
	public void gameOver(){
		gameOver = true;
	}

	public void setRound(int roundNumber) {
		round = "Round" + roundNumber;
		roundNumber++;
		update();
		
	}

	public void setSequenceSize(int size) {
		size = 0;
		sequence = "Sequence Size:" + size;
		size++;
		update();
		
	}

}
