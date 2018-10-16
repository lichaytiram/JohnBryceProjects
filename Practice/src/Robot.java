// try64 has done
public class Robot {
	private String Name;
	private int Health;
	private int Speed;
	private String[] Tactics = new String[4];

	public Robot(String name, int health, int speed, String[] tactics) {
		super();
		Name = name;
		Health = health;
		Speed = speed;
		Tactics = tactics;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public int getHealth() {
		return Health;
	}

	public void setHealth(int health) {
		Health = health;
	}

	public int getSpeed() {
		return Speed;
	}

	public void setSpeed(int speed) {
		Speed = speed;
	}

	public String[] getTactics() {
		return Tactics;
	}

	public void setTactics(String[] tactics) {
		Tactics = tactics;
	}

}
