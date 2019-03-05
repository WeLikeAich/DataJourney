package main.java.lab;

import main.java.models.Knight;
import main.java.models.Monk;
import main.java.models.Priest;
import main.java.models.Rogue;
import main.java.models.Character;

public class Polymorphism {

	public static void main(String[] args) {

		Character[] Party = new Character[] { new Knight(), new Monk(), new Priest(), new Rogue() };

		Knight TargetDummy = new Knight("TargetDummy");

		for (int i = 0; i < Party.length; i++) {

			Party[i].attack(TargetDummy);
			System.out.printf("%s attacks %s %n", Party[i].getName(), TargetDummy.getName());

			Party[i].useSpecial(TargetDummy);
			System.out.printf("%s uses %s on %s", Party[i].getName(), Party[i].SpecialName, TargetDummy.getName());

		}

	}

}
