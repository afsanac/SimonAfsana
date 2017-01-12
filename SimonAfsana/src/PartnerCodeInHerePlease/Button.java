package PartnerCodeInHerePlease;

import java.awt.Color;
import java.awt.Graphics2D;

import SimonAfsana.ButtonInterfaceAfsana;
import gui.components.Action;
import gui.components.Component;

public class Button extends Component implements ButtonInterfaceAfsana {

	private double cos;
	private Color color;
	private Color displayColor;
	private double sin;
	private Action action;
	public boolean highlighted;

	public Button(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		return false;
	}

	@Override
	public void update(Graphics2D g) {
		
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		
	}

	@Override
	public void setX(double cos) {
		this.cos = cos;
		
	}

	@Override
	public void setY(double sin) {
		this.sin = sin;
		
	}

	@Override
	public void setAction(Action action) {
		this.action = action;
		
	}

	@Override
	public void highlight() {
		if(color != null){
			highlighted = true;
			displayColor = color;
			update();
		}
		
	}

	@Override
	public void dim() {
		color = Color.gray;
		highlighted = false;
		update();
	}

}
