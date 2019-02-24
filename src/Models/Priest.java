package Models;

import java.util.ArrayList;

import enums.Statuses;

public class Priest {
	private String Name;
	private int MaxHealth = 100;
	private int Health = 100;
	private int Physical = 10;
	private int Intelligence = 20;
	private int Defense = 3;
	private String SpecialName = "Holy Light";
	private boolean isAlive = true;
	private ArrayList<Statuses> StatusesSet = new ArrayList<>();
	
	public Priest() {
		this("Priest");
	}
	
	public Priest(String name) {
		Name = name;
	}
	
	public boolean attack(Knight target) {
		if(!target.isAlive())
			return false;
		target.takeDamage(Intelligence/2);
		return true;
	}
	
	public boolean attack(Priest target) {
		if(!target.isAlive())
			return false;
		target.takeDamage(Intelligence/2);
		return true;
	}
	
	public boolean attack(Rogue target) {
		if(!target.isAlive())
			return false;
		target.takeDamage(Intelligence/2);
		return true;
	}
	
	public boolean attack(Monk target) {
		if(!target.isAlive())
			return false;
		target.takeDamage(Intelligence/2);
		return true;
	}
	
	public boolean useSpecial(Knight target) {
		
		target.setHealth(target.getHealth() + (Intelligence));
		
		if (target.getHealth() > target.getMaxHealth())
			target.setHealth(target.getMaxHealth());

		return true;
	}

	public boolean useSpecial(Priest target) {
		
		target.setHealth(target.getHealth() + (Intelligence));
		
		if (target.getHealth() > target.getMaxHealth())
			target.setHealth(target.getMaxHealth());

		return true;
	}
	
	public boolean useSpecial(Rogue target) {
		
		target.setHealth(target.getHealth() + (Intelligence));
		
		if (target.getHealth() > target.getMaxHealth())
			target.setHealth(target.getMaxHealth());

		return true;
	}
	
	public boolean useSpecial(Monk target) {
		
		target.setHealth(target.getHealth() + (Intelligence));
		
		if (target.getHealth() > target.getMaxHealth())
			target.setHealth(target.getMaxHealth());

		return true;
	}
	
	public void takeDamage(int attackAmount) {
		if(StatusesSet.contains(Statuses.StoneWall))
		{
			StatusesSet.remove(Statuses.StoneWall);
			return;
		}
		
		if(attackAmount < Defense)
			return;
		
		int damage = attackAmount - Defense;
		
		Health -= damage;
		
		if(Health <= 0) {
			Health = 0;
			isAlive = false;
		}
	}

	public boolean isAlive() {
		return isAlive;
	}
	
	public String getName() {
		return Name;
	}

	public int getMaxHealth() {
		return MaxHealth;
	}

	public int getHealth() {
		return Health;
	}

	public String getSpecialName() {
		return SpecialName;
	}

	public ArrayList<Statuses> getStatusesSet() {
		return StatusesSet;
	}
	
	public void setHealth(int health) {
		Health = health;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}