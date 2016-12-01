package NopecommerceProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by welcome on 21/11/2016.
 */
public class DriverManager {

    protected static WebDriver driver=null;

    public DriverManager (){PageFactory.initElements(driver,this);}

    public static void openBrowser (){
        String browser="chrome";
        if (browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","src\\test\\java\\Resources\\BrowserDriver\\chromedriver.exe");
            driver=new ChromeDriver();
        }
        else if((browser.equalsIgnoreCase("IE"))){

            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

            //capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");

            //capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);

           // capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            System.setProperty("webdriver.ie.driver", "src\\test\\java\\Resources\\BrowserDriver\\IEDriverServer.exe");
            driver=new InternetExplorerDriver(capabilities);

        }
        else {
            driver = new FirefoxDriver();}

        driver.get("http://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeBrowser(){
        driver.quit();
    }

}
