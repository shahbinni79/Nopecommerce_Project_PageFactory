package NopecommerceProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

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
    @Test
    public void robotclass_testing()throws AWTException{
        WebElement webele = driver.findElement(By.className("ico-login"));
        Point p = webele.getLocation();
        System.out.println("login location"+p);
        int x = p.getX();
        System.out.println("x= "+x);
        int y = p.getY();
        System.out.println("y= "+y);
        Dimension d = webele.getSize();
        System.out.println("dimention "+d);
        int h = d.getHeight();
        System.out.println("h= "+h);
        int w = d.getWidth();
        System.out.println("w= "+w);
        Robot r = new Robot();
        r.mouseMove(x + (w/2), y+(h/2) +80);
        System.out.println(1071+(33/2)+","+ 0+(45/2)+80);
    }


}
