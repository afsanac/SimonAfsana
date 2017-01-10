package SimonAfsana;

import gui.GUIApplication;

public class SimonGameAfsana extends GUIApplication {

	public SimonGameAfsana(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreenAfsana ssa = new SimonScreenAfsana(getWidth(), getHeight());
		setScreen(ssa);

	}
	
	public static void main(String[] args){
		SimonGameAfsana sga = new SimonGameAfsana(800, 500);
		Thread game = new Thread(sga);
		game.start();
	}

}
