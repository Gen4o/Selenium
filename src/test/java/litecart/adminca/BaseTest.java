package litecart.adminca;

import litecart.page.AdminPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class BaseTest {

    WebDriver driver;


    public void open(){
        AdminPage adminPage = new AdminPage(driver);
        adminPage.open();
    }
    public WebDriver setup(String browser){
        if(browser.equals("chrome")) {
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
