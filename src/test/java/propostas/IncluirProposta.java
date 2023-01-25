package propostas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IncluirProposta {

    WebDriver driver;

    String fornecedor = "99924356071";
    String senha = "123456";
    String pregao = "673";

    @BeforeTest
    public void iniciar() {

        System.setProperty("webdriver.chrome.driver", "drivers/chrome/109/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void logar() {
        String casoTeste = "Logar no PE";

        driver.get("http://localhost:8078/");

        driver.findElement(By.id("O1FD_id-innerCt")).click();
        driver.findElement(By.id("O2A3_id-inputEl")).click();
        driver.findElement(By.cssSelector(".x-boundlist-item-over")).click();
        driver.findElement(By.id("O263_id-inputEl")).click();
        driver.findElement(By.id("O263_id-inputEl")).sendKeys(fornecedor);
        driver.findElement(By.id("O277_id-inputEl")).click();
        driver.findElement(By.id("O277_id-inputEl")).sendKeys(senha);
        driver.findElement(By.id("O283_id-btnIconEl")).click();

        driver.findElement(By.linkText("Licitações")).click();

    }

@Test (dependsOnMethods = {"logar"})
    public void buscar(){

        driver.findElement(By.linkText("Licitações")).click();
        driver.findElement(By.id("O2DA_id-inputEl")).click();
        driver.findElement(By.id("O2DA_id-inputEl")).sendKeys(pregao);

    }

}
