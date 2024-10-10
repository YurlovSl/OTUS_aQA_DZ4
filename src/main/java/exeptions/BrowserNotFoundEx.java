package exeptions;

public class BrowserNotFoundEx extends RuntimeException{
    public BrowserNotFoundEx (String browserName){
        super(String.format("not found browser %s",browserName));
    }

}
