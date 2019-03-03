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

@DisplayName("Monk")
public class MonkTest {

	
	//////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////Tests////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	
	
	@Test
	void testMonk() {
		Character test = new Monk();

		assertEquals("Monk", test.getName());
	}

	@ParameterizedTest(name="Run {index}: testName= {0}")
	@MethodSource("testMonkString_Parameters")
	void testMonkString(String testName) {
		Character test = new Monk(testName);

		assertEquals(testName, test.getName());
	}

	@ParameterizedTest(name="Run {index}: target= {0}, resultingHealth= {1}")
	@MethodSource("testAttack_Parameters")
	void testAttack(Character target, int resultingHealth) {
		Character test = new Monk();

		test.attack(target);
		
		assertEquals(resultingHealth, target.Health);
	}
	
	@ParameterizedTest(name="Run {index}: target= {0}, status= {1}")
	@MethodSource("testUseSpecial_Parameters")
	void testUseSpecial(Character target, Statuses status) {
		Character test = new Monk();

		test.useSpecial(target);
		
		assertTrue(target.getStatusesSet().contains(status));
	}
	
	/////////////////////////////////////////////////////////////////////////////
	////////////////////////////////Test Parameters//////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	
	
	static Stream<Arguments> testUseSpecial_Parameters() throws Throwable {
		Statuses status = Statuses.Focus;
		
		return Stream.of(
				Arguments.of(new Knight(), status),
				Arguments.of(new Priest(), status),
				Arguments.of(new Rogue(), status),
				Arguments.of(new Monk(), status)
				);
	}
	
	static Stream<Arguments> testAttack_Parameters() throws Throwable {
		return Stream.of(
				Arguments.of(new Knight(), 113),
				Arguments.of(new Priest(), 86),
				Arguments.of(new Rogue(), 68),
				Arguments.of(new Monk(), 109)
				);
	}
	
	static Stream<Arguments> testMonkString_Parameters() throws Throwable {
		return Stream.of(
				Arguments.of("testName"),
				Arguments.of(""),
				Arguments.of("test name"),
				Arguments.of("125@@#%")
				);
	}
}
