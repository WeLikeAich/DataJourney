package models;

import java.util.ArrayList;

import enums.Statuses;

public class Monk extends Character {
	
	public Monk(String name) {
		this(1, name);
	}
	
	public Monk(int level, String name) {
		super(level, name);
		
		Physical *= 1.2;
		MaxHealth = Health *= 1.2;
		Intelligence *= .7;
		
		HealthLevelUpChance = 65;
		PhysicalLevelUpChance = 65;
		IntelligenceLevelUpChance = 20;
		DefenseLevelUpChance = 20;

		SpecialName = "Focus";
	}

	@Override
	protected int levelUp() {
		int chanceRoll = super.levelUp();
		
		if(PhysicalLevelUpChance >= chanceRoll)
			Physical += 1;
		if(HealthLevelUpChance >= chanceRoll)
			MaxHealth = Health *= 1.1;
		
		return chanceRoll;
	}
	
	@Override
	boolean attack(Character target) {
		int currentPhysical = Physical;
		
		if(StatusesSet.contains(Statuses.Focus))
			currentPhysical *= 1.5;
			
		return attack(target, currentPhysical);
	}

	@Override
	boolean useSpecial(Character target) {
		if(SpecialCooldownCounter != 0)
			return false;
		
		if(!target.equals(this))
			return false;
					
		if(!target.StatusesSet.contains(Statuses.Focus))
			target.StatusesSet.add(Statuses.Focus);
		
		SpecialCooldownCounter = SpecialCooldownResetValue;
		
		return true;
	}
}
