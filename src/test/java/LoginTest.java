import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void loadingLogin(){
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        assertEquals("Tareas App",driver.getTitle());
    }

    @Test
    public void testLoginErrorWithWrongInputs(){
        super.login("Holanda","1234");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        assertTrue(driver.findElement(By.id("swal2-content")).isDisplayed());
        assertEquals(driver.findElement(By.id("swal2-title")).getText(),"Email y password incorrectos");
        assertEquals(driver.findElement(By.id("swal2-content")).getText(),"401");
        assertNotEquals(driver.getCurrentUrl(),"localhost:3000/home");
    }

    @Test
    public void testLoginSuccessful(){
        super.register("Hola","1234");
        super.login("Hola","1234");
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        assertEquals(driver.getCurrentUrl(),"http://localhost:3000/home");
    }
}
