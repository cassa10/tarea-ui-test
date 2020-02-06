import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void setup(){
        //     System.setProperty("webdriver.chrome.driver","./");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("localhost:3000");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("loginButton"));
        emailInput.clear();
        passwordInput.clear();
        emailInput.sendKeys("Holanda");
        passwordInput.sendKeys("1234");
        loginButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals("React App",driver.getTitle());
    }
}
