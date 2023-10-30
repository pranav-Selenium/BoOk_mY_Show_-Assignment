package commonUtilityFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FunctionHandlingSchronyzation {

    WebDriver ldriver;

    public FunctionHandlingSchronyzation(WebDriver rdriver) {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }

    public void waitForLoad(long Seconds) {
        try {
            Thread.sleep(Seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
