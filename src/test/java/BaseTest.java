import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {


WebDriver driver;

   @BeforeAll
    public void setup(){
       WebDriverManager.chromedriver().setup();
       driver.get("https://www.amazon.com");
       driver.manage().window().maximize();

   }


   @AfterAll
    public void tearDown(){
       driver.quit();
   }

}
