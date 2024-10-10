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

public class DynamicMessageText_Test {
    private WebDriver driver;
    private Logger logger = LogManager.getLogger(DynamicMessageText_Test.class);
    private String baseUrl = System.getProperty("baseUrl");

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void startDriver() {
        logger.info("Открытие браузера в режиме " + ArgumentBrowser.FULL_SCREEN);
        driver = new BrowserFabrika().start(ArgumentBrowser.FULL_SCREEN);
    }

    @Test
    public void resultTest() {
        String name = "Yurlov";
        String email = "yurl@mail.ru";
        logger.info("Переход по ссылке");
        driver.get(baseUrl);
        WebElement fieldName = driver.findElement(By.id("name"));
        logger.info("Заполнение поля 'Имя'");
        fieldName.sendKeys(name);
        logger.info("Заполнение поля 'Email'");
        WebElement fieldEmail = driver.findElement(By.id("email"));
        fieldEmail.sendKeys(email);
        logger.info("Клик по кнопке 'Отправить'");
        driver.findElement(By.cssSelector("#sampleForm button")).click();
        WebElement dynamicMessage = driver.findElement(By.id("messageBox"));
        String expectedText = String.format("Форма отправлена с именем: %s и email: %s", name, email);
        logger.info("Проверка формата сообщения");
        assertThat(dynamicMessage.getText())
                .as("Сообщение формата: 'Форма отправлена с именем: <Имя> и email: <Email>'")
                .isEqualTo(expectedText);
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
