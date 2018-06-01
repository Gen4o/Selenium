package litecart.adminca;

import litecart.page.AdminPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import litecart.page.AdminPage;



public class MainPageTest extends BaseTest{

    WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
    public void init(@Optional("chrome") String browser){
        setup(browser);
    }

    @BeforeMethod
    public void openPage(){
        open();
    }

    @AfterMethod
    public void afterMethodText(){
        System.out.println("After every method");
    }


    @Test
    public void testCanLoginAsAdmin() throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.login("admin", "admin");
    }


}
