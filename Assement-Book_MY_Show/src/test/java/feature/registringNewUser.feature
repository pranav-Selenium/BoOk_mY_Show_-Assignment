Feature: User Authentication on BookMyShow

  Scenario Outline: Successful sign in with email
    Given I have launched the BookMyShow application
    And I have selected Bengaluru as my city
    When I navigate to the Sign In page
    And I choose to continue with EmailID
    And I enter "<email>" as the email and click on Continue
    Then I should be redirected to a third-party email service "<email_service>"
    When I enter username into the "<email>" field and access the inbox
    And I fetch the OTP from the latest email received from BookMyShow
    And I return to the BookMyShow sign in page and enter the fetched OTP
    Then The greeting message should display “Hi, Guest”

    Examples:
      | email                           | email_service |
      | moupreulluddafro-5173@bmn.ch.ma | https://yopmail.com/ |
