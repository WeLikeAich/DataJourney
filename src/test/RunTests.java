package test;

import java.util.Scanner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import test.java.listeners.CustomExecutionListener;
import test.java.suites.ClassesTestSuite;
import test.java.suites.InheritanceTestSuite;
import test.java.suites.PolymorphismTestSuite;

public class RunTests {
	public static void main(String[] args) {
		JUnitCore junit = new JUnitCore();

		junit.addListener(new CustomExecutionListener());


		Scanner scan = new Scanner(System.in);
		printMenu();
		int input = scan.nextInt();

		Class testSuiteClass = null;

		switch (input) {
		case 1:
			testSuiteClass = ClassesTestSuite.class;
			break;
		case 2:
			testSuiteClass = InheritanceTestSuite.class;
			break;
		case 3:
			testSuiteClass = PolymorphismTestSuite.class;
			break;
		default: 
			System.out.println("Invalid lab selection");
		}


		Result result = junit.run(testSuiteClass);

		if(result.wasSuccessful())
			System.out.println("All Tests Were Successful");
	}

	public static void printMenu() {
		StringBuilder sb = new StringBuilder();

		sb.append("Which lab are you testing?\n");
		sb.append("\t(1) Classes\n");
		sb.append("\t(2) Inheritance\n");
		sb.append("\t(3) Polymorphism\n");

		System.out.println(sb.toString());
	}
}