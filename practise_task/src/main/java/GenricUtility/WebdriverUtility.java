package GenricUtility;

import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;

public class WebdriverUtility {
	
	
	public void switchTowindow(WebDriver driver, String Title) {
		
		Set<String> Allid = driver.getWindowHandles();
		
		for(String id:Allid) {
			driver.switchTo().window(id);
			
			String actTitel = driver.getTitle();
			if(actTitel.contains(Title))
				break;
		}
		}

}
