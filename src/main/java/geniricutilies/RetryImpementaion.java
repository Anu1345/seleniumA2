package geniricutilies;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpementaion implements IRetryAnalyzer {
	int Count=0;
	int maxRetries=3;
	@Override
	public boolean retry(ITestResult result) {
		if(Count<maxRetries) {
			return true;
		}
		return false;
	}

}
