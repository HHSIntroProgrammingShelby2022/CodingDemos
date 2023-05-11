
public class Hero extends Sprite {

	private boolean moving;
	
	public Hero() {
		super ("Warrior.PNG",200,200,40,40);
		moving = false;
	}

	public void moveForward(boolean moving) {
		this.moving = moving;
	}
	
	public void act() {
		if (moving) {
			moveForward(4);
		}
	}
	
	
	
}
