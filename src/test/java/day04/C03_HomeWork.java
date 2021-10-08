package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_HomeWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id=\"signin_button\"]/i")).click();
        //3. Login alanine  “username” yazdirin
        WebElement user= driver.findElement(By.id("user_login"));
        user.sendKeys("username");
        //4. Password alanine “password” yazdirin
        WebElement password= driver.findElement(By.id("user_password"));
        password.sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/input")).click();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id=\"pay_bills_tab\"]/a")).click();
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//*[@id=\"sp_amount\"]")).sendKeys("1000");
        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//*[@id=\"sp_date\"]")).sendKeys("2020-09-10");
        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id=\"pay_saved_payees\"]")).click();
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement mesaj=driver.findElement(By.xpath("//*[@id=\"alert_content\"]/span"));
        System.out.println(mesaj.getText());
        driver.close();
    }
}
