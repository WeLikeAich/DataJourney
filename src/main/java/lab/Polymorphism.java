package main.java.lab;

import main.java.models.Knight;
import main.java.models.Monk;
import main.java.models.Party;
import main.java.models.Priest;
import main.java.models.Rogue;

public class Polymorphism {

	public static void main(String[] args) {

		Party PlayerParty = new Party(new Knight(), new Monk(), new Priest(), new Rogue());

		Knight TargetDummy = new Knight("TargetDummy");

		for (int i = 0; i < PlayerParty.Members.length; i++) {

			PlayerParty.Members[i].attack(TargetDummy);
			System.out.printf("%s attacks %s %n", PlayerParty.Members[i].getName(), TargetDummy.getName());

			PlayerParty.Members[i].useSpecial(TargetDummy);
			System.out.printf("%s uses %s on %s", PlayerParty.Members[i].getName(), PlayerParty.Members[i].SpecialName,
					TargetDummy.getName());

		}

	}

}
