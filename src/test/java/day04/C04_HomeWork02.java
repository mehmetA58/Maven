package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C04_HomeWork02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun=driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]"));
        System.out.println("Sayfadaki ilk urun ismi :"+ilkUrun.getText());
        ilkUrun.click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
       WebElement sepetKontrol= driver.findElement(By.id("remove-sauce-labs-backpack"));
       if (sepetKontrol.isDisplayed()){
           System.out.println("İlk ürün sepette TEST PASS");
       }else {
           System.out.println("İlk ürün sepette TEST FAİLED");
       }
       //9. Sayfayi kapatin
        driver.quit();
    }
}
