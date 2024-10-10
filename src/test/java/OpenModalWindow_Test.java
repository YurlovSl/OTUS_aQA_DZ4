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

public class OpenModalWindow_Test {

    private WebDriver driver;
    private Logger logger = LogManager.getLogger(SearchText_Test.class);
    private String baseUrl = System.getProperty("baseUrl");

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void startDriver() {
        logger.info("Открытие браузера в режиме " + ArgumentBrowser.KIOSK);
        driver = new BrowserFabrika().start(ArgumentBrowser.KIOSK);
    }

    @Test
    public void resultTest() {
        logger.info("Переход по ссылке");
        driver.get(baseUrl);
        WebElement buttonModulWindow = driver.findElement(By.id("openModalBtn"));
        buttonModulWindow.click();
        logger.info("Проверка открытия модального окна");
        assertThat(driver.findElement(By.cssSelector(".modal-content h2")).isDisplayed());
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
