package test.java.classes.polymorphism;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.java.enums.Statuses;
import main.java.models.Character;
import main.java.models.Knight;
import main.java.models.Monk;
import main.java.models.Priest;
import main.java.models.Rogue;

@DisplayName("Rogue")
public class RogueTest {

	
	//////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////Tests////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////

	@Test
	void testRogue() {
		Character test = new Rogue();

		assertEquals("Rogue", test.getName());
	}

	@ParameterizedTest(name="Run {index}: testName= {0}")
	@MethodSource("testRogueString_Parameters")
	void testRogueString(String testName) {
		Character test = new Rogue(testName);

		assertEquals(testName, test.getName());
	}

	@ParameterizedTest(name="Run {index}: target= {0}, resultingHealth= {1}")
	@MethodSource("testAttack_Parameters")
	void testAttack(Character target, int resultingHealth) {
		Character test = new Rogue();

		test.attack(target);
		
		assertEquals(resultingHealth, target.Health);
	}
	
	@ParameterizedTest(name="Run {index}: target= {0}")
	@MethodSource("testUseSpecial_Parameters")
	void testUseSpecial(Character target) {
		Character test = new Rogue();

		test.useSpecial(target);
		
		assertTrue(!target.isAlive());
		assertEquals(0, target.getHealth());
	}
	
	/////////////////////////////////////////////////////////////////////////////
	////////////////////////////////Test Parameters//////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	
	
	static Stream<Arguments> testUseSpecial_Parameters() throws Throwable {
		return Stream.of(
				Arguments.of(new Knight()),
				Arguments.of(new Priest()),
				Arguments.of(new Rogue()),
				Arguments.of(new Monk())
				);
	}
	
	static Stream<Arguments> testAttack_Parameters() throws Throwable {
		return Stream.of(
				Arguments.of(new Knight(), 110),
				Arguments.of(new Priest(), 83),
				Arguments.of(new Rogue(), 65),
				Arguments.of(new Monk(), 106)
				);
	}
	
	static Stream<Arguments> testRogueString_Parameters() throws Throwable {
		return Stream.of(
				Arguments.of("testName"),
				Arguments.of(""),
				Arguments.of("test name"),
				Arguments.of("125@@#%")
				);
	}
}
