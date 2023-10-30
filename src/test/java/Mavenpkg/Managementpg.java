package Mavenpkg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Managementpg {
WebDriver driver;

By logo=By.xpath("//header/div[1]/div[1]/a[1]/img[1]");
By Signin=By.xpath("//a[@id='signin']");
By email=By.xpath("//*[@id=\"email\"]");
By psswrd=By.xpath("//input[@id='password']");
By login=By.xpath("//*[@id=\"root\"]/div/section/div/div/div[3]/div[4]/div[1]");
By mouseover=By.linkText("Resumes");
By resume=By.linkText("Resume Examples");
By wh=By.xpath("/html/body/footer/div/div[2]/div/div/div/div/div[3]/a/img");
By home=By.linkText("No downloads or installations needed");
By profile=By.xpath("/html/body/header/div/div/div[2]/div[2]/div/a[1]");
By build=By.xpath("//body/div[@id='root']/div[1]/section[1]/div[1]/div[3]/div[1]/div[1]/div[1]/span[1]");
By use=By.xpath("//*[@id=\"root\"]/div/section/div/div/div[2]/div[1]/button/img");
By upload=By.xpath("//*[@id=\"root\"]/div/section/div/div[2]/div[2]/div/div");
By browse=By.xpath("//button[contains(text(),'Browse')]");
By save=By.xpath("//*[@id=\"ctl01_TemplateBody_WebPartManager1_gwpciNewContactMiniProfileCommon_ciNewContactMiniProfileCommon_contactPicture_submit\"]");
By sn=By.xpath("//*[@id=\"root\"]/div/section/div/div/div[3]/button[2]");
By next=By.xpath("//body/div[@id='root']/div[1]/section[1]/div[1]/div[3]/button[2]");
By n=By.xpath("//*[@id=\"root\"]/div/section/div/div/div[3]/div/button[2]");
By nsn=By.xpath("//*[@id=\"root\"]/div/section/div/div/div[3]/div[2]/button[3]");
By neducation=By.xpath("//button[@class='btn btn-primary btn-lg submit-on-enter']");
By skils=By.xpath("//button[@class='btn btn-primary btn-lg submit-on-enter save-n-next-btn']");
By summary=By.xpath("//button[@class='btn btn-primary btn-lg submit-on-enter']");
By review=By.xpath("//button[@class='btn btn-primary btn-lg submit-on-enter save-n-next-btn']");
By download=By.xpath("//button[@class='btn btn-primary btn-lg submit-on-enter']");
By finall=By.xpath("//button[@class='btn btn-primary btn-lg submit-on-enter save-n-next-btn']");
public Managementpg(WebDriver driver)
{
	  this.driver=driver;
		}
		
public void titleverification()
{
	String actualtitle=driver.getTitle();
	System.out.println(actualtitle);
	String expectedtitle="Create A Perfect Resume In 5 Minutes! | Online Resume Builder";
	if(actualtitle.equals(expectedtitle))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
}

public void contentverification()
{
	String contnt=driver.getPageSource();
	if(contnt.contains("Resume"))
			{
		System.out.println("this page contains the word Resume");
		
	}
	else
	{
		System.out.println("this page doesnot contains the word Resume");
	}
	
}
public void logodisplay()
{
	WebElement pn=driver.findElement(logo);
			boolean bo=pn.isDisplayed();
	if(bo)
	{
		System.out.println("logo displayed");
	}
	else
	{
		System.out.println("logo is not displayed");
	}
}	
		public void main() throws Exception  
		{
		
		driver.findElement(Signin).click();
		
		File f=new File("C:\\Users\\aneet\\OneDrive\\Desktop\\DATA\\VALUES.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Sheet1");
		System.out.println(sh.getLastRowNum());

		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			String Username=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(Username);
			String password=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(password);
			
			driver.findElement(email).sendKeys(Username);
			driver.findElement(psswrd).sendKeys(password);		
			Actions act=new Actions(driver);
			WebElement s=driver.findElement(login);
			act.moveToElement(s).click().build().perform();
			
			

		}
	}
	
		public void screenshot() throws Exception{
			File f=(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE));
			FileHandler.copy(f, new File("./Screenshot1/Management.png"));
		}
		
		public void mousehover() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Actions act=new Actions(driver);
			WebElement w=driver.findElement(mouseover);
			act.moveToElement(w);
			act.perform();
			driver.findElement(resume).click();
			
		}
		public void scrolldown() 
			{
					
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			}
		
		public void windowhandle() {
			String parentwindow=driver.getWindowHandle();
			driver.findElement(wh).click();
			Set<String> allwindowhandles = driver.getWindowHandles();
			for(String handle:allwindowhandles) {
				System.out.println(handle);
				
				if(!handle.equalsIgnoreCase(parentwindow)) {
					driver.switchTo().window(handle);
					System.out.println("package opened");
					driver.findElement(home).click();
				}
			}
			driver.switchTo().window(parentwindow);
		}
	
	public void fileuploadd() throws Exception {
		
			driver.findElement(build).click();
		driver.findElement(use).click();
		driver.findElement(upload).click();
		driver.findElement(browse).click();
			
			fileupload("C:\\Users\\aneet\\OneDrive\\Desktop\\Aneeta Catherin.pdf");
			
			
		}
		public void fileupload(String s) throws AWTException  {
			
			StringSelection strSelection=new StringSelection(s);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
			
			Robot robot=new Robot();
			robot.delay(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);;
			
			//driver.findElement(save).click();
			driver.findElement(next).click();
			driver.findElement(sn).click();
			driver.findElement(n).click();
			driver.findElement(nsn).click();
			driver.findElement(neducation).click();
			driver.findElement(skils).click();
			driver.findElement(summary).click();
			driver.findElement(review).click();
			driver.findElement(download).click();
			driver.findElement(finall).click();
		} 


}
