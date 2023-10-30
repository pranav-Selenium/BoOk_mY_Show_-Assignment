package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;

public class EmailServiceHomePage {

    WebDriver ldriver;
    public EmailServiceHomePage(WebDriver rdriver)
    {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }

   @FindBy(xpath="//input[@id='login']")
   private WebElement textInputArea;

    public void UsernameInputArea(String email){
        textInputArea.sendKeys(email);
    }

    @FindBy(xpath="//button[@title='Check Inbox @yopmail.com']")
    private WebElement checkInbox;

    public void CheckinboxButton(){
        checkInbox.click();
    }
}
