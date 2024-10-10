import enums.ArgumentBrowser;
import fabrika.BrowserFabrika;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchText_Test {

    private WebDriver driver;
    private Logger logger = LogManager.getLogger(SearchText_Test.class);
    private String baseUrl = System.getProperty("baseUrl");

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void startDriver() {
        logger.info("Открытие браузера в режиме " + ArgumentBrowser.HEADLESS);
        driver = new BrowserFabrika().start(ArgumentBrowser.HEADLESS);
    }

    @Test
    public void resultTest() {
        logger.info("Переход по ссылке");
        driver.get(baseUrl);
        WebElement input = driver.findElement(By.id("textInput"));
        logger.info("Ввод текста");
        input.sendKeys("ОТУС");
        logger.info("Проверка введенного текста и актуального");
        assertThat(input.getAttribute("value"))
                .as("Текст должен быть - 'ОТУС'")
                .isEqualTo("ОТУС");
    }

    @AfterEach
    public void downDriver() {
        logger.info("Закрытие браузера и сессии драйвера");
        if (driver != null) {
            driver.close();
            driver.quit();

        }
    }
}
