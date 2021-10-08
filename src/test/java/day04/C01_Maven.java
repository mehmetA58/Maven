package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01_Maven {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       //class'in başında implicitlywait komutu yazilirsa bu test

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2- arama kutusunu locate edelim
        WebElement searchBox=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));

        //3- “Samsung headphones” ile arama yapalim
        searchBox.sendKeys("Samsung headphones"+ Keys.ENTER);
        //4- Bulunan sonuc sayisini yazdiralim
        WebElement result=driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[1]"));
        //-->önemli!!!By.classname ile locate ettiğimiz webelementinde class attribute'nun degerinde
        //bosluk varsa locator saglıklı calişmayabilir
        System.out.println(result.getText());
        //5- Ilk urunu tiklayalim
       // WebElement ilkUrun=driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[1]/div/span/div/div/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span"));
       // ilkUrun.click();
        //6- Sayfadaki tum basliklari yazdiralim
        //span[@class='a-size-medium a-color-base a-text-normal'][1]
        List<WebElement> ürünler=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (int i = 1; i < ürünler.size(); i++) {
            System.out.println(i+".sıradaki ürün ismi: "+ürünler.get(i).getText());
        }


    }
}
