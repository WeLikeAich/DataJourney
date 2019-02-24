package Models;

import java.util.ArrayList;

import enums.Statuses;

public class Knight {
	private String Name;
	private int MaxHealth = 120;
	private int Health = 120;
	private int Physical = 10;
	private int Intelligence = 10;
	private int Defense = 10;
	private String SpecialName = "Stone Wall";
	private boolean isAlive = true;
	private ArrayList<Statuses> StatusesSet = new ArrayList<>();
	
	public Knight() {
		this("Knight");
	}
	
	public Knight(String name) {
		Name = name;
	}
	
	public boolean attack(Knight target) {
		if(!target.isAlive())
			return false;
		target.takeDamage(Physical);
		return true;
	}
	
	public boolean attack(Priest target) {
		if(!target.isAlive())
			return false;
		target.takeDamage(Physical);
		return true;
	}
	
	public boolean attack(Rogue target) {
		if(!target.isAlive())
			return false;
		target.takeDamage(Physical);
		return true;
	}
	
	public boolean attack(Monk target) {
		if(!target.isAlive())
			return false;
		target.takeDamage(Physical);
		return true;
	}
	
	public boolean useSpecial(Knight target) {	
		if(!target.getStatusesSet().contains(Statuses.StoneWall))
			target.getStatusesSet().add(Statuses.StoneWall);
		
		return true;
	}
	
	public boolean useSpecial(Priest target) {
		if(!target.getStatusesSet().contains(Statuses.StoneWall))
			target.getStatusesSet().add(Statuses.StoneWall);
		
		return true;
	}
	
	public boolean useSpecial(Rogue target) {
		if(!target.getStatusesSet().contains(Statuses.StoneWall))
			target.getStatusesSet().add(Statuses.StoneWall);
		
		return true;
	}
	
	public boolean useSpecial(Monk target) {
		if(!target.getStatusesSet().contains(Statuses.StoneWall))
			target.getStatusesSet().add(Statuses.StoneWall);
		
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

	public int getPhysical() {
		return Physical;
	}

	public int getIntelligence() {
		return Intelligence;
	}

	public int getDefense() {
		return Defense;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setMaxHealth(int maxHealth) {
		MaxHealth = maxHealth;
	}

	public void setPhysical(int physical) {
		Physical = physical;
	}

	public void setIntelligence(int intelligence) {
		Intelligence = intelligence;
	}

	public void setDefense(int defense) {
		Defense = defense;
	}

	public void setSpecialName(String specialName) {
		SpecialName = specialName;
	}

	public void setStatusesSet(ArrayList<Statuses> statusesSet) {
		StatusesSet = statusesSet;
	}
	
	
}
