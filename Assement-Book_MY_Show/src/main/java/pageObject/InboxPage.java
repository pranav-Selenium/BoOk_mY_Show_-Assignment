package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage {
    WebDriver ldriver;
    public InboxPage(WebDriver rdriver)
    {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }

    @FindBy(xpath ="(//div[@class='m'])[1]")
    private WebElement FirstiframeComponent;

    public void dealingWith_1st_iframe(){
        FirstiframeComponent.click();
    }
    @FindBy(xpath="//td[@style='text-decoration: none; color: rgba(51, 51, 51, 1); font-size: 24px; font-weight: 600']")
    private WebElement SecondFrameComponent;

    public String dealingWith2ndComponent(){
        String OTP_Value=SecondFrameComponent.getText();
        return OTP_Value;
    }
}
