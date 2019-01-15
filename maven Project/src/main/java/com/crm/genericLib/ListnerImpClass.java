package com.crm.genericLib;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImpClass implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult r) {
		String failedTestName=r.getMethod().getMethodName();
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.driver);
		File srcScreenshots=eDriver.getScreenshotAs(OutputType.FILE);
		File dstScreenshots=new File("./screenShots./"+failedTestName+".png");
		try {
			org.apache.commons.io.FileUtils.copyFile(srcScreenshots, dstScreenshots);
		}
		catch(Exception e) {
			
		}
	}

	@Override
	public void onTestSkipped(ITestResult r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
