
public class try64 {
	public static void main(String[] args) {

		Robot r1 = new Robot("Rocky", 110, 20, new String[] { "punch", "punch", "laser", "missile" });
		Robot r2 = new Robot("Missile Bob", 100, 21, new String[] { "missile", "missile", "missile", "missile" });
		System.out.println(fight(r1, r2));
	}

	public static String fight(Robot robot1, Robot robot2) {
		int punch = 20, laser = 30, missile = 35;
		int attack1 = 0, attack2 = 0;
		while (robot1.getHealth() > 0 && robot2.getHealth() > 0) {
			int temp1 = 0, temp2 = 0;
			// robot 1
			if (robot1.getTactics()[attack1].contains("punch")) {
				temp1 = punch;
			} else if (robot1.getTactics()[attack1].contains("laser"))
				temp1 = laser;
			else
				temp1 = missile;
			// robot 2
			if (robot2.getTactics()[attack2].contains("punch")) {
				temp2 = punch;
			} else if (robot2.getTactics()[attack2].contains("laser"))
				temp2 = laser;
			else
				temp2 = missile;
///////////////////////////////////////////////////////////////////////////////
			if (robot1.getSpeed() > robot2.getSpeed()) {
				robot2.setHealth(robot2.getHealth() - temp1);
				if (robot2.getHealth() <= 0)
					break;
				robot1.setHealth(robot1.getHealth() - temp2);
				if (robot1.getHealth() <= 0)
					break;
			} else {
				robot1.setHealth(robot1.getHealth() - temp2);
				if (robot1.getHealth() <= 0)
					break;
				robot2.setHealth(robot2.getHealth() - temp1);

			}
			attack1++;
			attack2++;
		}
		if (robot1.getHealth() > 0)
			return robot1.getName() + " has won the fight.";
		return robot2.getName() + " has won the fight.";
	}

}
