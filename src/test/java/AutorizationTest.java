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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutorizationTest {
    private WebDriver driver;
    private Logger logger = LogManager.getLogger(SeartTitileResultTest.class);


    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        driver = new ChromeDriver();
    }
    @Test
    public void resultTest() throws InterruptedException {
        logger.info("Переходим по ссылке");
        driver.get("https://otus.ru");

        logger.info("Находим селектор для Входа");
        driver.findElement(By.cssSelector(".sc-mrx253-0.enxKCy.sc-945rct-0.iOoJwQ")).click();
        logger.info("Находим селектор поля email");
        Thread.sleep(5000);
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        logger.info("Заполняем поле email");
        System.out.println(email.isDisplayed());
        System.out.println(email.isSelected());
        System.out.println(email.isEnabled());
        email.sendKeys("YurlovTest@mail.ru");
        logger.info("Находим селектор поля Пароль");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        logger.info("Заполняем поле Пароль");
        password.sendKeys("123456789QWw!");
        driver.findElement(By.xpath("//div[text()='Войти']")).click();
        logger.info(driver.manage().getCookies());


    }

    @AfterEach
    public void downDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
