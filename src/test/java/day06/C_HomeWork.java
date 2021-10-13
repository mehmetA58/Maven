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

import java.util.*;
import java.util.concurrent.TimeUnit;
////+"https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
////+ Web sitesindeki tüm öğeleri listeleyin
//// +Bir Dize Dizi Listesi oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
//// +Rastgele 5 öğe seçin, sepete ekleyin ve öğelerin adlarını yazdırın
////+ (Her ürün 1 defadan fazla eklenemez!)
//
//// +FİYATLARI GÖR!
////+ Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
//// +Sonuçlar eşleşiyorsa yazdırma başarı mesajı
//// Web Sitesinden dize fiyat değerlerini alın, ikiye dönüştürün ve <Double> ArrayList'e ekleyin ve fiyat listesini yazdırın
//// Ödemeye Tıkla

public class C_HomeWork {
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }
    @Test
    public void Listele() throws InterruptedException {
        Thread.sleep(2000);
       ArrayList<WebElement> ürünler= (ArrayList<WebElement>) driver.findElements(By.xpath("(//p[@class='shelf-item__title'])"));
       ArrayList<WebElement> fiyatlar= (ArrayList<WebElement>) driver.findElements(By.xpath("(//div[@class='val'])"));
        HashMap <Integer, Integer> fis = new HashMap<>();
        Thread.sleep(2000);
        for (int i = 0; i < ürünler.size(); i++) {
            System.out.println(i + 1 + ".sıradaki ürün ismi: " + ürünler.get(i).getText());
        }
        Thread.sleep(2000);
            for (int j = 0; j < fiyatlar.size(); j++) {
                System.out.println(fiyatlar.get(j).getText());
            }
    }

    @Test
    public void SepeteEkleKontrol() throws InterruptedException {
        driver.findElement(By.xpath("(//div[@class='shelf-item__buy-btn'])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='shelf-item__buy-btn'])[4]")).click();
        driver.findElement(By.xpath("(//div[@class='shelf-item__buy-btn'])[7]")).click();
        driver.findElement(By.xpath("(//div[@class='shelf-item__buy-btn'])[10]")).click();
        driver.findElement(By.xpath("(//div[@class='shelf-item__buy-btn'])[13]")).click();

        Thread.sleep(2000);
        List<WebElement> sepettekiUrnlerFiyat = new ArrayList<>();

        sepettekiUrnlerFiyat.add(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[4]/p")));
        sepettekiUrnlerFiyat.add(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[4]/p")));
        sepettekiUrnlerFiyat.add(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/div[4]/p")));
        sepettekiUrnlerFiyat.add(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div[4]/p")));
        sepettekiUrnlerFiyat.add(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/div[4]/p")));


       
        for (int i = 0; i < sepettekiUrnlerFiyat.size(); i++) {
            System.out.println("sepet : " + sepettekiUrnlerFiyat.get(i).getText());
        }
        double toplam = 0;
        for (int i = 0; i <sepettekiUrnlerFiyat.size() ; i++) {
            if (sepettekiUrnlerFiyat.get(i).getText().contains("$")){
                toplam+=Double.parseDouble(sepettekiUrnlerFiyat.get(i).getText().replace("$"," "));
            }
        }
        System.out.println("SUBTOTAL : "+toplam);
        System.out.println(driver.findElement(By.className("sub-price__val")).getText());
        String SubTotal=(driver.findElement(By.className("sub-price__val")).getText());

        if (SubTotal.equals(Double.toString(toplam))){
            System.out.println("Toplam Testi PASS");
        }else {
            System.out.println("Toplam testi FAİLED");
        }

        System.out.println("===============================================================================");
        Thread.sleep(2000);

        List<WebElement> sepettekiUrnIsim = driver.findElements(By.xpath("(//p[@class='title'])"));
        for (int i = 0; i < sepettekiUrnIsim.size(); i++) {
            System.out.println(i + 1 + ".ürün sepette isim: " + sepettekiUrnIsim.get(i).getText());
            System.out.println(i + 1 + " .element sepette görünür mü? = " + sepettekiUrnIsim.get(i).isDisplayed());
        }
        driver.findElement(By.xpath("(//div[@class='buy-btn'])")).click();

    }
   @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
