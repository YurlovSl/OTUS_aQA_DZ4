import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SeartTitileResultTest {
    private WebDriver driver;
    private Logger logger = LogManager.getLogger(SeartTitileResultTest.class);


    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }


    @Test
    public void resultTest() {
        logger.info("Переходим по ссылке");
        driver.get("https://duckduckgo.com/");
        String inputText = "ОТУС";
        logger.info("Находим селектор для ввода текста");
        WebElement inputRow = driver.findElement(By.cssSelector(".searchbox_input__bEGm3"));
        inputRow.clear();
        inputRow.sendKeys(inputText);
        logger.info("Находим селектор для кнопки поиска");
        WebElement searchButton = driver.findElement(By.cssSelector(".iconButton_icon__Vr1u2.iconButton_size-20__O3lP5"));
        searchButton.click();
        logger.info("Находим селектор для первой ссылки");
        WebElement firstLink = driver.findElement(By.cssSelector(".react-results--main>li:first-child .ikg2IXiCD14iVX7AdZo1"));
        String actual = firstLink.getText();
        String expected = "Онлайн‑курсы для профессионалов, дистанционное обучение современным ...";
        Assertions.assertEquals(expected, actual);
    }

    @AfterEach
    public void downDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
