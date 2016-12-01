package NopecommerceProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by welcome on 25/11/2016.
 */
public class EmailaFriend extends DriverManager {
    @FindBy (xpath = "//div[2]/ul/li/a")
    private WebElement _computers;

    @FindBy (xpath = "//div/div/div[2]/ul/li/ul/li[2]/a")
    private WebElement _notebook;

    @FindBy (xpath = "//h2/a")
    private WebElement _applenotebook;

    @FindBy (xpath = "//div[3]/input")
    private WebElement _emailafriend;

    @FindBy (xpath = "//div/h1")
    private WebElement _emailfriendtext;

    @FindBy (id = "FriendEmail")
    private WebElement _friendEmail;

    @FindBy (id="YourEmailAddress")
    private WebElement _youremail;

    @FindBy (name = "send-email")
    private WebElement _sendemailbtn;

    @FindBy (css = "div.result")
    private WebElement _emailsenttext;

    public void emailFriend () throws InterruptedException {


        Utils.clickOnElement(_computers);
       // Utils.mousehover(_notebook);
        //Thread.sleep(1000);
        Utils.clickOnElement(_notebook);
        //Thread.sleep(1000);
        Utils.clickOnElement(_applenotebook);
        Utils.clickOnElement(_emailafriend);
        Utils.enterText(_friendEmail,"mahi@alo.com");
        Utils.clickOnElement(_sendemailbtn);


    }
    public String getTexemailSentText(){
        return Utils.get_Text(_emailsenttext);
    }

}
