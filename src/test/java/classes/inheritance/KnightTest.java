package test.java.classes.inheritance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.enums.Statuses;
import main.java.models.Knight;
import main.java.models.Monk;
import main.java.models.Priest;
import main.java.models.Rogue;

@DisplayName("Knight")
public class KnightTest {

	@Test
	public void testKnight() {
		Knight test = new Knight();

		assertEquals("Knight", test.getName());
	}

	@Test
	public void testKnightString() {
		String knightName = "knightName";
		Knight test = new Knight(knightName);

		assertEquals(knightName, test.getName());
	}

	@Test
	public void testAttackKnight() {
		Knight test = new Knight();
		Knight target = new Knight();

		test.attack(target);

		assertEquals(target.getMaxHealth(), target.getHealth());
	}

	@Test
	public void testAttackPriest() {
		Knight test = new Knight();
		Priest target = new Priest();

		test.attack(target);

		assertEquals(93, target.getHealth());
	}

	@Test
	public void testAttackRogue() {
		Knight test = new Knight();
		Rogue target = new Rogue();

		test.attack(target);

		assertEquals(75, target.getHealth());
	}

	@Test
	public void testAttackMonk() {
		Knight test = new Knight();
		Monk target = new Monk();

		test.attack(target);

		assertEquals(116, target.getHealth());
	}

	@Test
	public void testUseSpecialKnight() {
		Knight test = new Knight();
		Knight target = new Knight();

		test.useSpecial(target);

		assertEquals(true, target.getStatusesSet().contains(Statuses.StoneWall));
	}

	@Test
	public void testUseSpecialPriest() {
		Knight test = new Knight();
		Priest target = new Priest();

		test.useSpecial(target);

		assertEquals(true, target.getStatusesSet().contains(Statuses.StoneWall));
	}

	@Test
	public void testUseSpecialRogue() {
		Knight test = new Knight();
		Rogue target = new Rogue();

		test.useSpecial(target);

		assertEquals(true, target.getStatusesSet().contains(Statuses.StoneWall));
	}

	@Test
	public void testUseSpecialMonk() {
		Knight test = new Knight();
		Monk target = new Monk();

		test.useSpecial(target);

		assertEquals(true, target.getStatusesSet().contains(Statuses.StoneWall));
	}

	@Test
	public void testTakeDamageNoShieldWallGreaterThanDefense() {
		Knight test = new Knight();

		test.takeDamage(20);

		assertEquals(110, test.getHealth());
	}

	@Test
	public void testTakeDamageNoShieldWallLessThanEqualToDefense() {
		Knight test = new Knight();

		test.takeDamage(10);

		assertEquals(test.getMaxHealth(), test.getHealth());
	}

	@Test
	public void testTakeDamageWithShieldWall() {
		Knight test = new Knight();

		test.useSpecial(test);

		test.takeDamage(10);

		assertEquals(test.getMaxHealth(), test.getHealth());
	}
}
