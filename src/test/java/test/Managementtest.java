package test;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Mavenpkg.Managementpg;



public class Managementtest {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		
	}
	@BeforeMethod
	public void url() {
		driver.get("https://resumebuild.com/");
	}
	@Test
	public void test() throws Exception  {
		Managementpg pg=new Managementpg(driver);
		driver.manage().window().maximize();
		pg.contentverification();
		pg.titleverification();
		pg.logodisplay();
		//pg.windowhandle();
		pg.mousehover();
		pg.scrolldown();
		pg.windowhandle();
		pg.main();
		pg.fileuploadd();
		driver.quit();

		}
	}


