package test;

import commons.TestDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SignUpPage;


public class SignUpPositiveFlow extends TestDriver {


  private String url= "https://coindcx.com/signup";

    SignUpPage signUpPage = new SignUpPage(this);


 @BeforeTest (alwaysRun = true)

 public void setUp() throws InterruptedException {
     launchBrowser(url);
    }

@Test

public void  testPositiveFlow()  {
     signUpPage.fillDetails();
 }

 @Test

public void testValidateEmailField()

 {
     signUpPage.enterEmail("Test");
     signUpPage.validateEmailMessage("Invalid Email ID");
     signUpPage.enterEmail("Test@test@.com");
     signUpPage.validateEmailMessage("Invalid Email ID");
 }


    @Test

    public void testValidatePassword()

    {
        signUpPage.enterPassword("1234567");
        signUpPage.validateMessage("Atleast 1 uppercase, 1 lowercase, 8 characters.");
        signUpPage.enterPassword("12345678");
        signUpPage.validateMessage("Atleast 1 uppercase, 1 lowercase.");
        signUpPage.enterPassword("12345678l");
        signUpPage.validateMessage("Atleast 1 uppercase.");
        signUpPage.enterPassword("12345678lK");
        signUpPage.validatePassword("Password strength medium");
        signUpPage.enterPassword("12345678lK@");
        signUpPage.validatePassword("Password strength strong");
    }

    @Test

    public void testValidatePhone()

    {
        signUpPage.enterPhoneNumber("987654321");
        signUpPage.validatePhoneMessage("Invalid phone number");
        signUpPage.enterPhoneNumber("98765432111");
        signUpPage.validatePhoneMessage("Invalid phone number");
    }


@AfterTest(alwaysRun = true)

public void tearDown()
{
closeBrowser();
}


}
