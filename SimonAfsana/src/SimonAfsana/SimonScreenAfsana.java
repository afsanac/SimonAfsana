package SimonAfsana;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;
import SimonAfsana.MoveInterfaceAfsana;
import SimonAfsana.SimonScreenAfsana;
import gui.components.Action;

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
		
		button = new ButtonInterfaceAfsana[numberOfButtons];
		for(int i = 0; i < numberOfButtons; i++ ){
			button[i] = getAButton();
			button[i].setName(names[i]);
			button[i].setColor(colors[i]);
			button[i].setX(160 + (int)(100*Math.cos(i*2*Math.PI/(numberOfButtons))));
			button[i].setY(200 - (int)(100*Math.sin(i*2*Math.PI/(numberOfButtons))));
			final ButtonInterfaceAfsana b = button[i];
			System.out.println(b+" has x = "+b.getX()+", y ="+b.getY());
			b.dim();
			button[i].setAction(new Action() {

				public void act() {

						Thread buttonPress = new Thread(new Runnable() {
							
							public void run() {
								b.highlight();
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
								
							}
						});
						buttonPress.start();
						

						if(acceptingInput && sequence.get(sequenceIndex).getButton() == b){
							sequenceIndex++;
						}else if(acceptingInput){
							gameOver();
							return;
						}
						if(sequenceIndex == sequence.size()){
							Thread nextRound = new Thread(SimonScreen.this);
							nextRound.start();
						}
					}

			});
			viewObjects.add(buttons[i]);
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterface>();
		//add 2 moves to start
		lastSelected = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;

		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private ButtonInterfaceAfsana getAButton() {
		// TODO Auto-generated method stub
		return PartnerCodeInHerePlease.Button();
	}

	public void run() {
		label.setText("");
		nextRound();
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		sequence.add(randomMove());
		ProgressInterfaceAfsana.setRound(roundNumber);
		ProgressInterfaceAfsana.setSequenceSize(sequence.size());
		changeText("Simon's Turn");
		label.setText("");
		playSequence();
		changeText("Your Turn");
		acceptingInput = true;
		sequenceIndex = 0;
		
	}


	private void changeText(String string) {
		// TODO Auto-generated method stub
		
	}

	private void playSequence() {
		// TODO Auto-generated method stub
		
	}
}