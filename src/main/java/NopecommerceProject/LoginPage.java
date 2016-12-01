package NopecommerceProject;

import org.openqa.jetty.util.Password;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by welcome on 21/11/2016.
 */
public class LoginPage extends DriverManager {

    @FindBy (linkText = "Log in")
    private WebElement _Loginbtn;

    @FindBy (id="Email")
    private WebElement _Enteremail;

    @FindBy (id= "Password")
    private WebElement _EnterPassword;

    @FindBy (xpath ="//input[@value='Log in']")
    private WebElement _Submitbtn;

    @FindBy (xpath = "//div[@class='header-links']/ul/li/a")
     private WebElement _loginconfrimationtex;

    public String loginConfirmationText (){
       return Utils.get_Text(_loginconfrimationtex);
    }

    public  void login_nopecommerce (){
        Registrationpage registration = new Registrationpage();
        registration.clickonregistrationbtn();
        registration.register();
        registration.logout();
        Utils.clickOnElement(_Loginbtn);
        Utils.enterText(_Enteremail,registration.acText);
        Utils.enterText(_EnterPassword,"laxmi2600");
        Utils.clickOnElement(_Submitbtn);
    }




}
