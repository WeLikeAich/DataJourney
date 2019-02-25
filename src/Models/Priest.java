package Models;

public class Priest extends Character {

	public Priest() {
		this("Priest");
	}

	public Priest(String name) {
		Name = name;
		MaxHealth = 100;
		Health = 100;
		Physical = 10;
		Intelligence = 20;
		Defense = 3;
		SpecialName = "Holy Light";
	}

	public boolean attack(Character target) {

		if (attack(target, Intelligence / 2)) {
			return true;
		}

		return false;
	}

	public boolean useSpecial(Character target) {

		target.setHealth(target.getHealth() + (Intelligence));

		if (target.getHealth() > target.getMaxHealth())
			target.setHealth(target.getMaxHealth());

		return true;
	}

}