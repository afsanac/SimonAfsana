package SimonAfsana;

import java.awt.Color;

import gui.components.Action;
import gui.components.Clickable;

public interface ButtonInterfaceAfsana extends Clickable {

	void setColor(Color color);

	void setX(double cos);

	void setY(double sin);

	void setAction(Action action);

	void highlight();

	void dim();

}
