package SeleniumPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;



public class Practice {
	
	public static WebDriver driver;
	
	public void getTitle() {
		driver.getTitle();
		driver.navigate().back();
		driver.switchTo().defaultContent();
		
		String parent_window=driver.getWindowHandle();
		
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1=s.iterator();
		while(I1.hasNext()) {
			I1.next();
			String Child_window=driver.getWindowHandle();
			if(parent_window.equals(Child_window)) {
				driver.switchTo().window(Child_window);
				break;
			}
			Actions action=new Actions(driver);
			
		
		}
	}
	

}
