import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected static WebDriver driver;

    @Before
    public void setup(){
        //System.setProperty("webdriver.chrome.driver","");
        driver = new ChromeDriver();
        destroyDatabase();
        driver.manage().window().maximize();
        driver.get("localhost:3000");
    }

    @After
    public void tearDown(){
        destroyDatabase();
        driver.quit();
    }

    private void destroyDatabase(){
        driver.get("localhost:8080/dropAll?u=admin&p=admin1234");
    }

    public void login(String email,String password){
        driver.get("localhost:3000");
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        emailInput.clear();
        passwordInput.clear();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void register(String email, String password) {
        driver.get("localhost:3000/registrarse");
        WebElement emailInput = driver.findElement(By.id("email-register"));
        WebElement passwordInput = driver.findElement(By.id("password-register"));
        WebElement signupButton = driver.findElement(By.id("button-register"));
        emailInput.clear();
        passwordInput.clear();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signupButton.click();
    }

}
