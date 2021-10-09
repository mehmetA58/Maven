package day06;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class C03_Assertions {
    //Bir Class olusturalim YanlisEmailTesti
    //http://automationpractice.com/index.php sayfasina gidelim
    //Sign in butonuna basalim
    //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
    //    “Invalid email address” uyarisi ciktigini test edelim
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }
    @Test
    public void gecersizMailTesti() throws InterruptedException {
        driver.findElement(By.partialLinkText("Sign in")).click();
        Thread.sleep(3000);
        WebElement emailGiriskutusu=driver.findElement(By.id("email_create"));
        emailGiriskutusu.sendKeys("MerhabaTelevole" + Keys.ENTER);
        Thread.sleep(3000);
        WebElement hatayazisielementi=driver.findElement(By.id("create_account_error"));
        Assert.assertTrue("Mesaj gorunmedi",hatayazisielementi.isDisplayed());
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}