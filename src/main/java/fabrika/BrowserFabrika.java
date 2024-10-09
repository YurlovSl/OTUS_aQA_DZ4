package fabrika;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFabrika implements IbrowserFabrika{
    private String typeBrowserFromProperty = System.getProperty("browser");



    @Override
    public WebDriver start() {
        switch (typeBrowserFromProperty){
            case "chrome":
                return new ChromeDriver();
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
        }
        return null;
    }
}
