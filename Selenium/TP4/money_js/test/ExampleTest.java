import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedCondition.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.junit.Assert.*;

import org.junit.*;

public class ExampleTest {
    WebDriver driver;
    @Before
    public void createDriver() {
    	System.setProperty("webdriver.chrome.driver", "/home/pierre/Documents/oti/TP4");
    	driver = new ChromeDriver();
    }

    @After
    public void freeDriver() {
       driver.quit();
    }

    @Test
    public void test_add_same_curr() throws java.io.IOException{
        driver.get("http://127.0.0.1:8000/TP4/money_js/src/index.html");

        WebElement element = driver.findElement(By.name("v1"));
        element.sendKeys("2");

        element = driver.findElement(By.name("c1"));
        element.sendKeys("EUR");

        element = driver.findElement(By.name("v2"));
        element.sendKeys("4");

        element = driver.findElement(By.name("c2"));
        element.sendKeys("EUR");

        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d) {
			   return d.findElement(By.id("res")).getText().trim().length()>0;
			}
        });

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/tmp/screenshot_add_same_curr.png"));

		assertEquals(driver.findElement(By.id("res")).getText(),"Result : 6 (EUR)");
		new File("/tmp/screenshot_add_same_curr.png").delete();
    }


    @Test
    public void test_soustraction_ok() throws java.io.IOException{
        driver.get("http://127.0.0.1:8000/TP4/money_js/src/index.html");

        WebElement element = driver.findElement(By.name("v1"));
        element.sendKeys("5");

        element = driver.findElement(By.name("c1"));
        element.sendKeys("EUR");

        element = driver.findElement(By.name("v2"));
        element.sendKeys("2");

        element = driver.findElement(By.name("c2"));
        element.sendKeys("EUR");

        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("res")).getText().trim().length()>0;
            }
        });

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/screenshot_soustrcation_ok.png"));

        assertEquals(driver.findElement(By.id("res")).getText(),"Result : 3 (EUR)");
        new File("/tmp/screenshot_soustrcation_ok.png").delete();
    }


    @Test
    public void test_pas_la_same_devise() throws java.io.IOException{
        driver.get("http://127.0.0.1:8000/TP4/money_js/src/index.html");

        WebElement element = driver.findElement(By.name("v1"));
        element.sendKeys("5");

        element = driver.findElement(By.name("c1"));
        element.sendKeys("EUR");

        element = driver.findElement(By.name("v2"));
        element.sendKeys("2");

        element = driver.findElement(By.name("c2"));
        element.sendKeys("CHF");

        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("res")).getText().trim().length()>0;
            }
        });

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/pas_la_same_devise.png"));

        assertEquals(driver.findElement(By.id("res")).getText(),"Devises incompatibles : EUR vs CHF");
        new File("/tmp/pas_same_devise").delete();
    }

    @Test
    public void test_soustraction_impossible() throws java.io.IOException{
        driver.get("http://127.0.0.1:8000/TP4/money_js/src/index.html");

        WebElement element = driver.findElement(By.name("v1"));
        element.sendKeys("5");

        element = driver.findElement(By.name("c1"));
        element.sendKeys("EUR");

        element = driver.findElement(By.name("v2"));
        element.sendKeys("6");

        element = driver.findElement(By.name("c2"));
        element.sendKeys("EUR");

        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("res")).getText().trim().length()>0;
            }
        });

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/screenshot_soustrcation_impossible.png"));

        assertEquals(driver.findElement(By.id("res")).getText(),"Result : soustraction impossible");

        new File("/tmp/soustraction_impossible.png").delete();
    }

@Test
   public void test_valeurInfAZero() throws java.io.IOException{
        driver.get("http://127.0.0.1:8000/TP4/money_js/src/index.html");

        WebElement element = driver.findElement(By.name("v1"));
        element.sendKeys("-5");

        element = driver.findElement(By.name("c1"));
        element.sendKeys("EUR");

        element = driver.findElement(By.name("v2"));
        element.sendKeys("6");

        element = driver.findElement(By.name("c2"));
        element.sendKeys("EUR");

        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("res")).getText().trim().length()>0;
            }
        });

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/screenshot_valeurInfAZero.png"));

        assertEquals(driver.findElement(By.id("res")).getText(),"Result : Valeur Inferieur à zero");

        new File("/tmp/valeurInfAZero.png").delete();
    }


}
