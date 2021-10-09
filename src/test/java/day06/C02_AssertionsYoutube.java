package day06;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class C02_AssertionsYoutube {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //   ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //  ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com/");
        //driver.findElement(By.xpath("//*[text()='I Agree']")).click();
    }
    @Test
    public void titleTest(){
        String expectedTitle="YouTube";
        String actualTitle= driver.getTitle();
        Assert.assertEquals("Sayfa title'i beklenenden farkli",expectedTitle,actualTitle);
    }
    @Test
    public void logoTesti(){
        WebElement logo=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue("Logo gorunmuyor",logo.isDisplayed());
    }
    @Test
    public void aramaKutusuTesti(){
        WebElement aramaKutusu=driver.findElement(By.id("search-input"));
        Assert.assertTrue("Arama kutusuna ulasilamiyor", aramaKutusu.isEnabled());
    }
    @Test
    public void yanlisTitleTesti(){
        String istenmeyenBaslik="youtube";
        String actualTitle= driver.getTitle();
        Assert.assertNotEquals("Title istenmeyen kelimeye esit",istenmeyenBaslik,actualTitle);
        Assert.assertFalse("false mesaji",istenmeyenBaslik.equals(actualTitle));
        Assert.assertTrue("True Mesaji",!istenmeyenBaslik.equals(actualTitle));
    }
    @AfterClass
    public static void tearDown(){

        driver.close();
    }
}