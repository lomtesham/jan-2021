package part1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lomte Sir\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    
	    driver.navigate().to("https://www.naukri.com/");
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		
		//WebElement tabbutton=driver.findElement(By.xpath("//button[@id='tabButton']"));
		
		//tabbutton.click();

		//WebElement windowButton=driver.findElement(By.xpath("//button[@id='windowButton']"));
		
		//windowButton.click();
		
		//WebElement messageWindowButton=driver.findElement(By.xpath("//button[@id='windowButton']"));
		
		//messageWindowButton.click();
		
		
		
		String MainWindow=driver.getWindowHandle();
		Set<String> ChildWindows=driver.getWindowHandles();
		Iterator<String> itr=ChildWindows.iterator();
		
		while(itr.hasNext())
		{
			String childwindow=itr.next();
			
			if(!MainWindow.equalsIgnoreCase(childwindow))
			{
				driver.switchTo().window(childwindow);
				
				driver.findElement(By.tagName("a")).click();
				
			/*	String text=driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
			//	System.out.println(text);
				System.out.println(driver.getCurrentUrl());
				String title=driver.getTitle().toString();
				System.out.println(title);
				
				System.out.println(driver.getPageSource());
				*/
				
			}
		}
	}

}
