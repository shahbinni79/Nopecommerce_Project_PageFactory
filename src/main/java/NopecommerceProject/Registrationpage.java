package NopecommerceProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by welcome on 22/11/2016.
 */
public class Registrationpage extends DriverManager {

    @FindBy(className = "ico-register")
    private WebElement _Register;

    @FindBy(xpath = "//div[@class='page registration-page']/div/h1")
    private WebElement _RegisterText;

    @FindBy(id = "gender-female")
    private WebElement _Gender;

    @FindBy(id = "FirstName")
    private WebElement _EnterFirstName;

    @FindBy(id = "LastName")
    private WebElement _EnterLastName;

    @FindBy(name = "DateOfBirthDay")
    private WebElement _DOB;

    @FindBy(name = "DateOfBirthMonth")
    private WebElement _MOB;

    @FindBy(name = "DateOfBirthYear")
    private WebElement _YOB;

    @FindBy(id = "Email")
    private WebElement _email;

    @FindBy(id = "Password")
    private WebElement _password;

    @FindBy(id = "ConfirmPassword")
    private WebElement _ConfirmPassword;

    @FindBy(id = "register-button")
    private WebElement _registerbtn;

    @FindBy(css = "h2")
    private WebElement _homepagetext;

    @FindBy(className = "ico-account")
    private WebElement _ACText;

    @FindBy(className = "result")
    private WebElement _confirmRegestration;

    @FindBy(className = "ico-logout")
    private WebElement _logout;


    public String homepage() {
        Utils.driverWaitExplicitly(_homepagetext, 5);
        return Utils.get_Text(_homepagetext);
    }

    public void clickonregistrationbtn() {
        Utils.driverWaitExplicitly(_Register, 10);
        Utils.clickOnElement(_Register);
    }

    public String registrationPage() {              //This will give text to assert registration completion

        return Utils.get_Text(_RegisterText);
    }

    public  static String acText=null;    //this is null string which will save username which will be
                                        // used later for login. String is out side of the method so we can use
                                        // it in other methods
    public  void register() {
        Utils.driverWaitExplicitly(_Register, 10);
        Utils.clickOnElement(_Register);
        String email = "laxmi" + Utils.randomdate() + "@gmail.com";
        Utils.clickOnElement(_Gender);
        Utils.enterText(_EnterFirstName, "Laxmi");
        Utils.enterText(_EnterLastName, "Venepalli");
        Utils.selectElementByValue(_DOB, "2");
        Utils.selectElementByVisibletext(_MOB, "June");
        Utils.selectElementByValue(_YOB, "2000");
        Utils.enterText(_email, email);
        Utils.enterText(_password, "laxmi2600");
        Utils.enterText(_ConfirmPassword, "laxmi2600");
        Utils.clickOnElement(_registerbtn);
        acText = new String();
        acText=Utils.get_Text(_ACText); // This text i.e username will be saved in null
        //


    }

    public boolean registrationSuccessfulMessage() {
        return Utils.isElement_Present(_confirmRegestration);
    }



    public void logout() {
        Utils.clickOnElement(_logout);
    }





}
