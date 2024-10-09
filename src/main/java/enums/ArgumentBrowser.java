package enums;

public enum ArgumentBrowser {
    HEADLESS("--headless"),
    KIOSK("--kiosk"),
    FULL_SCREEN("--start-fullscreen"),
    DEFAULT(null);

    private String argumentBrowser;

    ArgumentBrowser(String argumentBrowser) {
        this.argumentBrowser = argumentBrowser;
    }
}
