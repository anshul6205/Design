package SeleniumPractice;

import org.testng.ITestListener;

public class ItestListeners implements ITestListener {

	public void onStart(ITestListener context) {
		System.out.println("OnStart" + context.getClass());
	}

	public void onFinish(ITestListener context) {
		System.out.println("onFinish" + context.getClass());
	}

	public void onTestSuccess(ITestListener result) {
		System.out.println("onTestSuccess" + result.getClass());
	}

	public void onTestFailure(ITestListener result) {
		System.out.println("onTestFailure" + result.getClass());
	}

	public void onTestSkipped(ITestListener result) {
		System.out.println("onTestSkipped" + result.getClass());
	}

}
