package PartnerCodeInHerePlease;

import SimonAfsana.ButtonInterfaceAfsana;
import SimonAfsana.MoveInterfaceAfsana;

public class MoveJon implements MoveInterfaceAfsana {

	private ButtonInterfaceAfsana b;

	public MoveJon(ButtonInterfaceAfsana b) {
		this.b = b;
	}
	
	public ButtonInterfaceAfsana getButton(){
		return b;
		
	}

}
