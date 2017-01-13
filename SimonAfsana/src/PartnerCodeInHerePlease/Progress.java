package PartnerCodeInHerePlease;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import SimonAfsana.ProgressInterfaceAfsana;
import gui.components.Component;

public class Progress extends Component implements ProgressInterfaceAfsana {
	
	public static final int HEIGHT = 60;
	public static final int WIDTH = 120;

	public boolean gameOver;
	public String round;
	public String sequence;
	
	public Progress() {
		super(85, 85, WIDTH, HEIGHT);
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		if(gameOver){
			g.setColor(Color.black);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.white);
			String gameOver = "Game Over!";
			g.drawString(gameOver, WIDTH - fm.stringWidth(gameOver)/2, 0);
			g.drawString(sequence,  WIDTH - fm.stringWidth(sequence)/2, 40);
			
		}else{
			if(round != null && sequence != null){
				g.drawString(round, WIDTH - fm.stringWidth(round)/2, 20);
				g.drawString(sequence, WIDTH - fm.stringWidth(sequence)/2, 40);
			}
		}

	}
	
	public void gameOver(){
		gameOver = true;
		update();
	}

	public void setRound(int roundNumber) {
		round = "Round" + roundNumber;
		update();
		
	}

	public void setSequenceSize(int size) {
		size = 0;
		sequence = "Sequence Size:" + size;
		update();
		
	}

}
