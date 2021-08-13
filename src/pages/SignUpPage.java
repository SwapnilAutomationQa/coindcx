package pages;


import commons.TestDriver;


public class SignUpPage {

    TestDriver driver;

    public SignUpPage(TestDriver driver) {
        this.driver = driver;
    }



    private String firstName= "//*[@name='firstName']";
    private String lastName= "//*[@name='lastName']";
    private String email= "//*[@name='email']";
    private String password= "//*[@name='password']";
    private String phone= "//*[@name='phone']";
    private String captcha= "//*[@id='recaptcha-anchor']";
    private String registerButton="//*[@id='recaptcha-anchor']";
    private String validationMessage= "//div[@class='ng-tns-c82-3 ng-trigger ng-trigger-transitionMessages ng-star-inserted']";
    private String validationEmailMessage= "//div[@class='mat-form-field-subscript-wrapper ng-tns-c82-2']";
    private String validationMessagePassword="//div[@class='heading-error-wrapper password-checker-container']";
    private String validatePhoneMessage= "//div[@class='c-new__heading-error-wrapper -ta-left']";






    public void fillDetails ()  {

         driver.sendValues(firstName, "FirstName");
        driver.sendValues(lastName, "lastName");
        driver.sendValues(email, "test@test.com");
        driver.sendValues(password, "Coindcx@2021");
        driver.sendValues(phone, "8082367615");
        /*
        Navigating to captcha frame
        driver.switchToFrame("a-l5b6b5xja22r");

        Clicking on captcha Checkbox
         driver.clickElement(captcha);

         Clicking on register buttom
          driver.clickElement(registerButton);
        */
      }

      public void enterEmail(String emailID)
      {
          driver.sendValues(email, emailID);
      }

    public void enterPassword(String passwordText)
    {
        driver.sendValues(password, passwordText);
    }


      public void validateMessage(String message)

      {
          driver.verifyMessage(validationMessage,message);
      }

    public void validateEmailMessage(String email)

    {
        driver.verifyMessage(validationEmailMessage,email);
    }


    public void enterPhoneNumber(String passwordText)
    {
        driver.sendValues(phone, passwordText);
    }

      public void validatePhoneMessage (String phone)

      {
          driver.verifyMessage(validatePhoneMessage,phone);
      }

    public void validatePassword(String email)

    {
        driver.verifyMessage(validationMessagePassword,email);
    }

}

