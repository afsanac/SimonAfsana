package PartnerCodeInHerePlease;

import SimonAfsana.ButtonInterfaceAfsana;
import SimonAfsana.MoveInterfaceAfsana;

public class Move implements MoveInterfaceAfsana {

	private ButtonInterfaceAfsana b;

	public Move(ButtonInterfaceAfsana b) {
		this.b = b;
	}
	
	public ButtonInterfaceAfsana getButton(){
		return b;
		
	}

}
