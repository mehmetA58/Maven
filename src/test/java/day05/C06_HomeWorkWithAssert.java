package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C06_HomeWorkWithAssert {
    //1-Test01 isimli bir class olusturun
    //2- https://www.amazon.com/ adresine gidin
    //3- Browseri tam sayfa yapin
    //4-Sayfayi “refresh” yapin
    //5- Sayfa basliginin “Amazon” ifadesi icerdigini control edin
    //6-Sayfa basliginin “Amazon.com. Spend less. Smile more.” a esit oldugunu control ediniz
    //7- URL in amazon.com icerdigini control edin
    //8-”Nutella” icin arama yapiniz
    //9- Kac sonuc bulundugunu yaziniz
    //10-Sayfayi kapatin
    WebDriver driver;

    @Before//-->static'e gerek kalmadığı için daha tatlı
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void test1(){
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        String title=driver.getTitle();

        Assert.assertTrue(title.contains("Amazo"));


        Assert.assertEquals("Amazon.com. Spend less. Smile more.",title);

        String URL= driver.getCurrentUrl();

        Assert.assertTrue(URL.contains("amazon.com"));

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        WebElement result=driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[1]"));
        System.out.println("result.getText() = " + result.getText());

    }
    @After
    public void tearDown(){
        driver.close();
    }

}


