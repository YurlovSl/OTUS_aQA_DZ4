package fabrika;


import enums.ArgumentBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFabrika implements IbrowserFabrika {
    private String typeBrowserFromProperty = System.getProperty("browser");

    public WebDriver start(ArgumentBrowser argumentBrowser) {
        switch (typeBrowserFromProperty) {
            case "chrome": {
                if (argumentBrowser.equals(ArgumentBrowser.FULL_SCREEN)) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");
                    return new ChromeDriver(options);
                } else if (argumentBrowser.equals(ArgumentBrowser.HEADLESS)) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(String.valueOf(ArgumentBrowser.HEADLESS));
                    return new ChromeDriver(options);
                } else if (argumentBrowser.equals(ArgumentBrowser.KIOSK)) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(String.valueOf(ArgumentBrowser.KIOSK));
                    return new ChromeDriver(options);
                } else if (argumentBrowser.equals(ArgumentBrowser.DEFAULT)) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(String.valueOf(ArgumentBrowser.DEFAULT));
                    return new ChromeDriver(options);

                }
            }
        }

        return null;
    }


}
