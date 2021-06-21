import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CampoTreinamento {

    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/felipe.rubim/Desktop/componentes.html");

    }

    @Test
    public void textField(){
        String Nome = "Felipe";
        String Sobrenome = "Ferreira";
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Felipe");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Ferreira");
        Assert.assertEquals("Felipe", Nome);
        Assert.assertEquals("Ferreira", Sobrenome);
    }

    @Test
    public void checkBox(){
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
    }

    @Test
    public void selectCombo(){
        //Escolaridade
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Superior");

        //Esporte
        WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
        Select combo1 = new Select(elemento);
        combo1.selectByVisibleText("Natacao");
    }

    @Test
    public void clickCadastrar(){
        driver.findElement(By.id("elementosForm:cadastrar")).click();
    }


    @After
    public void finishAndValidate(){
        driver.quit();
    }
}
