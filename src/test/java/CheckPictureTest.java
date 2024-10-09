
import fabrika.BrowserFabrika;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckPictureTest {

    private WebDriver driver;
    private Logger logger = LogManager.getLogger(CheckPictureTest.class);



    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

//    @BeforeEach
//    public void startDriver() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--kiosk");
//        driver = new ChromeDriver(options);
//    }
    @BeforeEach
    public void startDriver() {
        driver = new BrowserFabrika().start();

    }


    @Test
    public void resultTest() {

        logger.info("Переходим по ссылке");
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
        logger.info("Находим селектор для открытия картинки");
        WebElement picture = driver.findElement(By.cssSelector(".portfolio-area.clearfix.p-0.m-0>li:nth-child(4)"));
        logger.info("Нажимаем на картинку");
        picture.click();
        logger.info("Проверка что картинка открылась в модальном окне");
        driver.findElement(By.cssSelector(".pp_content_container")).isDisplayed();
    }

    @AfterEach
    public void downDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
