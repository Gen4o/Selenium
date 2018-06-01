package litecart.adminca;

import litecart.page.AdminPage;
import litecart.util.Dataproviders;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestLitecartAdmin extends BaseTest{



    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void init(@Optional("chrome") String browser){
        setup(browser);
    }

    @BeforeMethod(alwaysRun = true)
    public void openPage(){
        open();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethodText(){
        System.out.println("After every method");
    }


    @Test(groups = "login")
    public void testCanLoginAsAdmin() throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.login("admin", "admin");
    }



    @Test(groups = "login")
    public void testCanSuccessfulLogout() throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.login("admin","admin")
                .logout();

    }


    @Test(groups = "alert")
    public void testCheckAlertMessageForEmptyUserData() throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        String alertText;
        alertText = adminPage.getAlertText();
        Assert.assertEquals(alertText,"×" + "\n" +"You must provide a username");
    }


    //data from file
    @Test(dataProvider = "loginFormCheck", dataProviderClass = Dataproviders.class, groups = "dataproviders")
    public void testLoginForm(String login, String password) throws InterruptedException {
        new AdminPage(driver).login(login, password);

    }

    //hardcode data
    @Test(dataProvider = "test1", dataProviderClass = Dataproviders.class, groups = "dataproviders")
    public void testLoginFormHardcode(String login, String password) throws InterruptedException {
        new AdminPage(driver).login(login, password);

    }



    @AfterClass(alwaysRun = true)
    public void close(){
        driver.quit();
    }




}
