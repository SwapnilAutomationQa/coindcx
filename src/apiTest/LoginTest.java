package apiTest;

import commons.RestAssuredTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

public class LoginTest extends RestAssuredTest {

    private String loginApi="https://api.coindcx.com/api/v3/authenticate";
    RestAssuredTest restAssuredTest = new RestAssuredTest();

    @Test
    public void testOtpLogin()

    {
        File body= new File ("./src/resources/login.json");
        restAssuredTest.postRequest(loginApi,body);
        Assert.assertEquals(response.getStatusCode(),422);
        Assert.assertEquals(getJsonValue("message"),"Invalid OTP");

    }

    @Test
    public void testEmailValidation()

    {
        // Test Email Blank
        File body= new File ("./src/resources/emailBlank.json");
        File invalidEmail= new File ("./src/resources/emailinvalid.json");
        restAssuredTest.postRequest(loginApi,body);
        Assert.assertEquals(response.getStatusCode(),422);
        Assert.assertEquals(getJsonValue("message"),"Email can't be blank");
        // Test Email Invalid
        restAssuredTest.postRequest(loginApi,invalidEmail);
        Assert.assertEquals(response.getStatusCode(),422);
        Assert.assertEquals(getJsonValue("message"),"Email is invalid");
    }

    @Test
    public void validateAuthentication()
    {
        // Authenticate the login
        File body= new File ("./src/resources/authentication.json");
        restAssuredTest.postRequest(loginApi,body);
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(getJsonValue("message"),"Otp sent");
        Assert.assertEquals(getBooleanValue("verify_device"),Boolean.TRUE);
    }

    @Test
    public void validateLoginUnauthorized()
    {
        File body= new File ("./src/resources/unauthorized.json");
        restAssuredTest.postRequest(loginApi,body);
        Assert.assertEquals(response.getStatusCode(),401);
        Assert.assertEquals(getJsonValue("message"),"Invalid Credentials");
        Assert.assertEquals(getJsonValue("status"),"unauthorized");
    }

    @Test
    public void testMaximus5Attempts()
    {
        File body= new File ("./src/resources/authentication.json");
        restAssuredTest.postRequest(loginApi,body);
        Assert.assertEquals(response.getStatusCode(),429);
        Assert.assertEquals(getJsonValue("message"),"Maximum 5 attempts allowed in 5 minutes");
        Assert.assertEquals(getJsonValue("status"),"error");
    }

}
