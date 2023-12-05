package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MyAccountsTest extends BaseTest {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    AccountCreationPage accountCreationPage = new AccountCreationPage();
    AccountPage accountPage = new AccountPage();
    LoginPage loginPage = new LoginPage();
    LogOutPage logoutPage = new LogOutPage();

    //    1.1 create method with name "selectMyAccountOptions" it has one parameter name
//"option" of type string
//1.2 This method should click on the options whatever name is passed as parameter.
//            (Hint: Handle List of Element and Select options)
//    Write the following test

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        homePage.clickOnMyAccount();

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");

        //1.3 Verify the text “Register Account”.
        Assert.assertEquals(homePage.getRegisterAccountText(), "Register Account", "Register page not displayed");

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {

//2.1 Click on My Account Link.
        homePage.clickOnMyAccount();

//2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectMyAccountOptions("Login");
        Thread.sleep(2000);

//            2.3 Verify the text “Returning Customer”.
        Assert.assertEquals(homePage.getLoginAccountText(), "Returning Customer", "Login page not displayed");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {


//3.1 Click on My Account Link.
        homePage.clickOnMyAccount();

//3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");

//3.3 Enter First Name
        registerPage.sendFirstName("Jack");

        //3.4 Enter Last Name
        registerPage.sendLastName("Doe");

        //3.5 Enter Email
        registerPage.sendEmail("patel");

        //3.6 Enter Telephone
        registerPage.sendTelephone("07653445678");

        //3.7 Enter Password
        registerPage.sendPassword("Hello123");

        //3.8 Enter Password Confirm
        registerPage.sendConfirmPassword("Hello123");

        //3.9 Select Subscribe Yes radio button
        registerPage.clickOnSubscribeToNewsletter();

        //3.10 Click on Privacy Policy check box
        registerPage.clickOnPrivacyPolicy();

        //3.11 Click on Continue button
        registerPage.clickOnContinueAfterPrivacyButton();

        //3.12 Verify the message “Your Account Has Been Created!”
        Thread.sleep(2000);
        Assert.assertEquals(accountCreationPage.getAccountCreationMessage(), "Your Account Has Been Created!", "account not created");

        //3.13 Click on Continue button
        accountCreationPage.clickOnContinueAfterAccountCreation();

        //3.14 Click on My Account Link.
        accountPage.clickOnMyAccountLink();

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        accountPage.selectMyAccountOption("Logout");

        //3.16 Verify the text “Account Logout”
        Assert.assertEquals(logoutPage.getTextFromLogout(), "Account Logout", "not logged out");

        //3.17 Click on Continue button
        accountPage.clickOnContinueAfterLogout();

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {

        //4.1 Click on My Account Link.
        homePage.clickOnMyAccount();

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectMyAccountOptions("Login");

        //4.3 Enter Email address
        loginPage.sendEmail("rajesh_kumar01@gmail.com");

        //4.5 Enter Password
        loginPage.sendPassword("12345678");

        //4.6 Click on Login button
        loginPage.clickOnLogin();

        //4.7 Verify text “My Account”
        Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "Not on my account");

        //4.8 Click on My Account Link.
        accountPage.clickOnMyAccountLink();

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        homePage.selectMyAccountOptions("Logout");

        //4.10 Verify the text “Account Logout”
        Assert.assertEquals(logoutPage.getTextFromLogout(), "Account Logout", "Not logged out");

        //4.11 Click on Continue button
        logoutPage.clickOnContinueButton();

    }
}