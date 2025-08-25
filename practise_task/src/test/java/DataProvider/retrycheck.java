package DataProvider;

import org.testng.Assert;
import org.testng.annotations.Test;

public class retrycheck {
	@Test(retryAnalyzer =DataProvider.RetryAnalyser.class )
	
	public void test() {
		System.out.println("execute Testmethod");
		Assert.assertEquals("", "Login");
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("4");
	}

}
