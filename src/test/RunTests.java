package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import test.java.listeners.CustomExecutionListener;
import test.java.suites.CharacterTypeTestSuite;

public class RunTests {
	public static void main(String[] args) {
		JUnitCore junit = new JUnitCore();
		
		junit.addListener(new CustomExecutionListener());
		Result result = junit.run(CharacterTypeTestSuite.class);

		if(result.wasSuccessful())
			System.out.println("All Tests Were Successful");
	}
}