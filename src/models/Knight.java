package models;

import java.util.ArrayList;

import enums.Statuses;

public class Knight extends Character {
	
	public Knight(String name) {
		this(1, name);
	}
	
	public Knight(int level, String name) {
		super(level, name);
		MaxHealth = Health *= 1.2;
		Physical *= .7;
		
		HealthLevelUpChance = 75;
		PhysicalLevelUpChance = 25;
		IntelligenceLevelUpChance = 15;
		DefenseLevelUpChance = 35;
		
		SpecialName = "Stone Wall";
	}
	
	@Override
	protected int levelUp() {
		int chanceRoll = super.levelUp();
		
		if(HealthLevelUpChance >= chanceRoll)
			Health = MaxHealth *= 1.2;
		
		return chanceRoll;
	}
	
	@Override
	boolean attack(Character target) {
		// TODO Auto-generated method stub
		return attack(target, Physical);
	}

	@Override
	boolean useSpecial(Character target) {
		// TODO Auto-generated method stub
		if(SpecialCooldownCounter != 0)
			return false;
					
		if(!target.StatusesSet.contains(Statuses.StoneWall))
			target.StatusesSet.add(Statuses.StoneWall);
		
		SpecialCooldownCounter = SpecialCooldownResetValue;
		
		return true;
	}
}
