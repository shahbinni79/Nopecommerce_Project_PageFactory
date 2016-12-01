package NopecommerceProject;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by welcome on 21/11/2016.
 */
public class TestSuit extends DriverManager {



    @BeforeTest
    public  void open(){
        DriverManager.openBrowser();
    }

    @AfterTest
    public  void close(){
        DriverManager.closeBrowser();
    }

//    Registrationpage registration = new Registrationpage();        declaring these objects here is not working
//    LoginPage loginpage = new LoginPage();
//    ElectronicsPage electronicsPage = new ElectronicsPage();
//    PaymentPage paymentPage = new PaymentPage();
//    EmailaFriend emailafriend = new EmailaFriend();



    @Test
    public  void varifyUserIsabletoRegister(){
        Registrationpage registration = new Registrationpage();
        Assert.assertEquals(registration.homepage(),"Welcome to our store");
        registration.clickonregistrationbtn();
        Assert.assertEquals(registration.registrationPage(),"Register");
        registration.register();
        Assert.assertTrue(registration.registrationSuccessfulMessage(),"Your registration completed");
        registration.logout();
    }



   @Test
    public  void varifyUserisAbleToLogin (){
       Registrationpage registration = new Registrationpage();
       LoginPage loginpage=new LoginPage();
       loginpage.login_nopecommerce();
       Assert.assertEquals(loginpage.loginConfirmationText(),registration.acText);
       registration.logout();


    }

    @Test
    public  void varifyItemsInCart () throws InterruptedException {
        Registrationpage registration = new Registrationpage();
        ElectronicsPage electronicsPage = new ElectronicsPage();
       // Assert.assertEquals(registration.homepage(),"Welcome to our store");
        registration.clickonregistrationbtn();
      //  Assert.assertEquals(registration.registrationPage(),"Register");
        registration.register();
        electronicsPage.addtocart();
        electronicsPage.goToCart();
        electronicsPage.cart_SubTotal();
        registration.logout();

    }

    @Test
    public  void varifyPayment () throws InterruptedException {
        Registrationpage registration = new Registrationpage();
        ElectronicsPage electronicsPage = new ElectronicsPage();
        PaymentPage paymentPage = new PaymentPage();
       // Assert.assertEquals(registration.homepage(),"Welcome to our store");
        registration.clickonregistrationbtn();
        //Assert.assertEquals(registration.registrationPage(),"Register");
        registration.register();
        electronicsPage.addtocart();
        electronicsPage.goToCart();
        electronicsPage.cart_SubTotal();
        paymentPage.checkout();
        Assert.assertEquals(paymentPage.getconfirmationmessage(),"Your order has been successfully processed!");
        registration.logout();
    }

    @Test
    public  void emailAFriend () throws InterruptedException {
        Registrationpage registration = new Registrationpage();
        EmailaFriend emailafriend = new EmailaFriend();
        registration.clickonregistrationbtn();
      //  Assert.assertEquals(registration.registrationPage(),"Register");
        registration.register();
        emailafriend.emailFriend();
        Assert.assertEquals(emailafriend.getTexemailSentText(),"Your message has been sent.");
        registration.logout();
    }


}
