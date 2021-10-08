package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_Test01 {
    public static void main(String[] args) {
        //1-Test01 isimli bir class olusturun
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //2- https://www.walmart.com/ adresine gidin
        driver.get("https://www.walmart.com/");
        //3- Browseri tam sayfa yapin
        //4-Sayfayi “refresh” yapin
       // driver.navigate().refresh();
        //5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        String actTitle= driver.getTitle();
        String arananTitle="Save";
        if (actTitle.contains(arananTitle)){
            System.out.println("Tittle TEST PASS");
        }else{
            System.out.println("Tittle TEST FAİLED");
        }

        //6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        String expextedTitle="Walmart.com | Save Money.Live Better";
        if (expextedTitle.equals(actTitle)){
            System.out.println("Tam başlık eşit testi PASS");
        }else {
            System.out.println("TAm başlık esit testi FAİLED");
        }


        //7- URL in walmart.com icerdigini control edin
        String actURL=driver.getCurrentUrl();
        String expevtedURL="walmart.com";

        if (actURL.contains(expevtedURL)){
            System.out.println("URL iceriyor TESTİ PASS");
        }else {
            System.out.println("URL iceriyor TESTİ FAİLED");
        }
        //8-”Nutella” icin arama yapiniz
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/span/header/div/form/div/input"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //9- Kac sonuc bulundugunu yaziniz
        WebElement sonucMiktarı= driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/main/div/div[2]/div/div/div[1]/div/div/h2"));
        System.out.println(sonucMiktarı.getText());
        //10-Sayfayi kapatin
        driver.close();
    }
}
