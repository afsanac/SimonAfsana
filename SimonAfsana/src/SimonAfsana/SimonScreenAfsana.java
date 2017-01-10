package SimonAfsana;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class SimonScreenAfsana extends ClickableScreen implements Runnable {
	
	private TextLabel label;
	private ButtonInterfaceAfsana[] button;
	private ProgressInterfaceAfsana progress;
	private ArrayList<MoveInterfaceAfsana> sequence;
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenAfsana(int width, int height) {
		super(height, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceAfsana>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);

	}

	private MoveInterfaceAfsana randomMove() {
		ButtonInterfaceAfsana move; 
		int choice = (int) (6 * Math.random());
		while(choice == lastSelectedButton){
			choice = (int) (6 * Math.random());
		}
		move = button[choice];
		return getMove(move);
	}

	private MoveInterfaceAfsana getMove(ButtonInterfaceAfsana move) {
		return null;
	}

	private ProgressInterfaceAfsana getProgress() {
		/**
		Placeholder until partner finishes implementation of ProgressInterface
		*/
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 4;
		Color[] colorArray = new Color[numberOfButtons];
		colorArray[0] = Color.blue;
		colorArray[0] = Color.red;
		colorArray[0] = Color.yellow;
		colorArray[0] = Color.green;
		
	}

	@Override
	public void run() {
		label.setText("");
		nextRound();
	}

	private void nextRound() {
		// TODO Auto-generated method stub
		
	}
	

}
