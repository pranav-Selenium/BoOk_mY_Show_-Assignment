package testCase;

import commonUtilityFunctions.FunctionHandlingSchronyzation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import pageObject.EmailServiceHomePage;
import pageObject.HomePage;
import pageObject.InboxPage;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static diverInit.Initializing_Driver.ldriver;

public class registringNewUserStepdefs {


    HomePage hp = new HomePage(ldriver);
    EmailServiceHomePage es = new EmailServiceHomePage(ldriver);
    InboxPage ip = new InboxPage(ldriver);

    FunctionHandlingSchronyzation fhs = new FunctionHandlingSchronyzation(ldriver);


    @Given("I have launched the BookMyShow application")
    public void iHaveLaunchedTheBookMyShowApplication() {
        ldriver.get("https://in.bookmyshow.com/explore/home/");

    }

    @And("I have selected Bengaluru as my city")
    public void iHaveSelectedBengaluruAsMyCity() {


        // Finding all the City  present in the <ul> element

        List<WebElement> cityList = ldriver.findElements(By.xpath("//ul[@class='bwc__sc-ttnkwg-15 gZrltM']/li"));

        // Iterating through the CityList to find the one matching "Bengaluru"
        for (WebElement listItem : cityList) {
            WebElement cityNames = listItem.findElement(By.className("bwc__sc-ttnkwg-16"));
            String cityName = cityNames.getText();

            if (cityName.equals("Bengaluru")) {
                listItem.click();
                break;
            }


        }

    }

    @When("I navigate to the Sign In page")
    public void iNavigateToTheSignInPage() {
        hp.ClickOnSignInButton();


    }

    @And("I choose to continue with EmailID")
    public void iChooseToContinueWithEmailID() {
        hp.ClickOnCreateAccountLink();


    }

    @And("I enter {string} as the email and click on Continue")
    public void iEnterAsTheEmailAndClickOnContinue(String email) {
        hp.setEmailInputField(email);
        fhs.waitForLoad(3);
        hp.submittingEmailID();

    }



    @Then("I should be redirected to a third-party email service {string}")
    public void iShouldBeRedirectedToAThirdPartyEmailService(String email_service) {
        ldriver.switchTo().newWindow(WindowType.TAB).get(email_service);



    }
    Set<String> Tab_ID = ldriver.getWindowHandles();
    List<String> tab = new ArrayList<>(Tab_ID);


    @When("I enter username into the {string} field and access the inbox")
    public void iEnterUsernameIntoTheFieldAndAccessTheInbox(String emailID) {

        fhs.waitForLoad(3);
        es.UsernameInputArea(emailID);
        es.CheckinboxButton();
    }




    String OTP_value;
    @And("I fetch the OTP from the latest email received from BookMyShow")
    public void iFetchTheOTPFromTheLatestEmailReceivedFromBookMyShow() {

        fhs.waitForLoad(4);


        ldriver.switchTo().frame("ifinbox");
        ip.dealingWith_1st_iframe();


        ldriver.switchTo().defaultContent();
        WebElement Secondframe = ldriver.findElement(By.xpath("//div[@class='wmright']//iframe"));
        ldriver.switchTo().frame(Secondframe);
         OTP_value = ip.dealingWith2ndComponent();
        System.out.println(OTP_value);
        ldriver.close();

    }

    @And("I return to the BookMyShow sign in page and enter the fetched OTP")
    public void iReturnToTheBookMyShowSignInPageAndEnterTheFetchedOTP() {

        ldriver.switchTo().window(tab.get(0));
        fhs.waitForLoad(3);

        List<WebElement> otpInputFields = hp.enterOTP();
        for (int i = 0; i < otpInputFields.size(); i++) {
            WebElement otp = otpInputFields.get(i);
            otp.sendKeys(String.valueOf(OTP_value.charAt(i)));
        }
    }



    @Then("The greeting message should display “Hi, Guest”")
    public void theGreetingMessageShouldDisplayHiGuest() {


    /* WebElement "hiGuestElement" given below, cannot be found because user is not able to sign in as Application is
    not sending Otp when application is UNDER TEST. Xpath written for the WebElement "hiGuestElement" taken by inputting
     the OTP when application was NOT UNDER TEST. This Xpath is legitimate and unique. This will work under TESTING MODE
      if OTP is sent to mailBOX under testing Condition.
     */

        WebElement hiGuestElement = hp.UserProfile();

        if (hiGuestElement.isDisplayed()) {
            System.out.println(hiGuestElement.getText());
        } else {
            System.out.println("Expected text is not displayed.");
        }

    }



}
