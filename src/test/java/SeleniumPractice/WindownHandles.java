package SeleniumPractice;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Listeners(SeleniumPractice.ItestListeners.class)
public class WindownHandles {
	
	public static WebDriver driver;
	
	@Test
	public static void WindowHandle() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\anshu\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String ParentWindow=driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1=s.iterator();
		while(I1.hasNext()) {
			String chil_window=I1.next();
			if(ParentWindow.equals(chil_window)) {
				driver.switchTo().window(chil_window);
				break;
			}
		}
		driver.switchTo().window(ParentWindow);
		driver.quit();
		
		File srcfile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationpath="";
		FileUtils.copyFile(srcfile,new File(destinationpath));
		
		WebElement ele=driver.findElement(By.xpath(""));
		Actions act=new Actions(driver);
		act.moveToElement(ele).build().perform();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
//		js.executeScript("arguments[0].scrollIntoView(true);",ele);
		
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight");
		
//		js.executeScript("arguments[0].click;", ele);
		
//		js.executeScript("arguments[0].value;",ele);
		
//		js.executeScript("window.scrollBy(0,200);");
		
//		js.executeScript("return document.title;");
		
//		js.executeScript("arguments[0].style.border='3px solid red';", ele);
		
//		js.executeScript("document.body.style.zoom='80%';");
		
	}
	
	public static String ExcelValue() throws IOException {
		String sharename = " ";
		FileInputStream file=new FileInputStream("C:/Users/anshu/Downloads/dividends-XN1183-2022_2023 (1).xlsx");
		Workbook wb=new XSSFWorkbook(file);
		Sheet sh=wb.getSheet("Equity Dividends");
		for(int i=1;i<=sh.getLastRowNum();i++) {
			Row row=sh.getRow(i);
			sharename=row.getCell(0).getStringCellValue();
			System.out.println(sharename);
		}
		wb.close();
		return sharename;
		
	}

	
	
	
	

}
