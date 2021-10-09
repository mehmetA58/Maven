package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C06_HomeWork {
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
        if (title.contains("Amazon")){
            System.out.println("Title Amazon içeriyor Test PASS");
        }else {
            System.out.println("Title Amazon içeriyor Test FAİLED");
        }
        if (title.equals("Amazon.com. Spend less. Smile more.")){
            System.out.println("Title Amazon.com. Spend less. Smile more.eşit Test PASS");
        }else {
            System.out.println("Title Amazon.com. Spend less. Smile more.eşit Test FAİLED");
        }
        String URL= driver.getCurrentUrl();
        if (URL.contains("amazon.com")){
            System.out.println("URL amazon.com içeriyor Test PASS");
        }else {
            System.out.println("URL amazon.com içeriyor Test FAİLED");
        }
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
       WebElement result=driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[1]"));
        System.out.println("result.getText() = " + result.getText());

    }
    @After
    public void tearDown(){
        driver.close();
    }

}
