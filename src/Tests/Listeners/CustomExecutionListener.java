package tests.listeners;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class CustomExecutionListener extends RunListener{
    public void testFailure(Failure failure) throws Exception {
        System.out.println("Failed: " + failure.getDescription().getClassName() + "." +failure.getDescription().getMethodName());
    }

    public void testAssumptionFailure(Failure failure) {
    	System.out.println("Assumption Failed: " + failure.getDescription().getClassName() + "." +failure.getDescription().getMethodName());
    }

    public void testIgnored(Description description) throws Exception {
        System.out.println("Ignored: " + description.getClassName() + "." + description.getMethodName());
    }
}
