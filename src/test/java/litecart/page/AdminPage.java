package litecart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    WebDriver driver;



    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



    //private static String username = "username";
    //private static String password = "password";
    //private static String submitButton = "[type='submit']";

    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(css = "[type='submit']")
    WebElement submitButton;



    @FindBy(css = ".alert.alert-danger")
    WebElement alertMessageText;


    public MainAdminPage login(String username, String password) throws InterruptedException {

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
        return new MainAdminPage(driver);

//        driver.findElement(By.name(username)).sendKeys(username);
//        driver.findElement(By.name(password)).sendKeys(password);
//        driver.findElement(By.cssSelector(submitButton)).click();
    }

    public void open() {
        driver.get("http://localhost/litecart/admin");
    }



    public String getAlertText() throws InterruptedException {
        String alertText;
        submitButton.click();
        //driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(2000);
        alertText = alertMessageText.getText();
        //alertText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        return alertText;
    }


}
