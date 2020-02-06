import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class RegisterTest extends BaseTest {

    @Test
    public void testRegisterWithoutInputs(){
        driver.get("localhost:3000/registrarse");
        driver.findElement(By.id("button-register")).click();
    }

    @Test
    public void testRegisterIsSuccessful(){
        super.register("a","a");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertTrue(driver.findElement(By.id("swal2-content")).isDisplayed());
        assertEquals(driver.findElement(By.id("swal2-title")).getText(),"Cuenta registrada");
        assertEquals(driver.findElement(By.id("swal2-content")).getText(),"Ingrese desde el login, por favor");
    }

    @Test
    public void testRegisterIsNotSuccessful(){
        super.register("a","a");
        super.register("a","a");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertTrue(driver.findElement(By.id("swal2-content")).isDisplayed());
        assertEquals(driver.findElement(By.id("swal2-title")).getText(),"Algo malio sal");
        assertEquals(driver.findElement(By.id("swal2-content")).getText(),"El email ya existe");
    }
}
