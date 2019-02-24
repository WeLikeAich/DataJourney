package Models;

import java.util.ArrayList;

import enums.Statuses;

public class Monk {
	private String Name;
	private int MaxHealth = 120;
	private int Health = 120;
	private int Physical = 17;
	private int Intelligence = 15;
	private int Defense = 6;
	private String SpecialName = "Focus";
	private boolean isAlive = true;
	private ArrayList<Statuses> StatusesSet = new ArrayList<>();
	
	public Monk() {
		this("Monk");
	}
	
	public Monk(String name) {
		Name = name;
	}
	
	public boolean attack(Knight target) {
		if(!target.isAlive())
			return false;
		
		int currentPhysical = Physical;
		
		if(StatusesSet.contains(Statuses.Focus))
			currentPhysical *= 1.5;
		
		target.takeDamage(currentPhysical);
		return true;
	}
	
	public boolean attack(Priest target) {
		if(!target.isAlive())
			return false;
		
		int currentPhysical = Physical;
		
		if(StatusesSet.contains(Statuses.Focus))
			currentPhysical *= 1.5;
		
		target.takeDamage(currentPhysical);
		return true;
	}
	
	public boolean attack(Rogue target) {
		if(!target.isAlive())
			return false;
		
		int currentPhysical = Physical;
		
		if(StatusesSet.contains(Statuses.Focus))
			currentPhysical *= 1.5;
		
		target.takeDamage(currentPhysical);
		return true;
	}
	
	public boolean attack(Monk target) {
		if(!target.isAlive())
			return false;
		
		int currentPhysical = Physical;
		
		if(StatusesSet.contains(Statuses.Focus))
			currentPhysical *= 1.5;
		
		target.takeDamage(currentPhysical);
		return true;
	}
	
	public boolean useSpecial() {
		if(!StatusesSet.contains(Statuses.Focus))
			StatusesSet.add(Statuses.Focus);
		
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