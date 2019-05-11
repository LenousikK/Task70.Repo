import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginPage extends PageBasis {
    private static final String URL = "https://www.tut.by/";
    private static final String LOGIN_TITLE = "Белорусский портал TUT.BY. Новости Беларуси и мира";
    private static final By LOGIN_MENU_ITEM = By.xpath("//a[@class = 'enter']");
    private static final By INPUT_LOGIN_USERNAME = By.xpath("//input[@name = 'login']");
    private static final String LOGIN_USERNAME = "seleniumtests@tut.by";
    private static final By INPUT_LOGIN_PASSWORD = By.xpath("//input[@name = 'password']");
    private static final String LOGIN_PASSWORD = "123456789zxcvbn";
    private static final By BUTTON_LOGIN_SUBMIT = By.xpath("//input[@class = 'button auth__enter']");
    private static final By LABEL_LOGGED_USER_NAME = By.xpath("//span[@class = 'uname']");
    private static final By LINK_LOGOUT_MENU_ITEM = By.xpath("//a[@class = 'enter logedin']");
    private static final By BUTTON_LOGOUT = By.xpath("//a[@class = 'button wide auth__reg']");
    private static final By LABEL_BUTTON_LOGOUT = By.xpath("//a[@class = 'enter']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get(URL);
    }

    public String loginTitle() {
        return LOGIN_TITLE;
    }

    public WebElement loginMenuItem() {
        WebElement loginMenuItem = driver.findElement(LOGIN_MENU_ITEM);
        return loginMenuItem;
    }

    public void enterLoginUsername() {
        WebElement inputLoginUsername = driver.findElement(INPUT_LOGIN_USERNAME);
        inputLoginUsername.sendKeys(LOGIN_USERNAME);
    }

    public void enterLoginPassword() {
        WebElement inputLoginPassword = driver.findElement(INPUT_LOGIN_PASSWORD);
        inputLoginPassword.sendKeys(LOGIN_PASSWORD);
    }

    public WebElement buttonLoginSubmit() {
        WebElement buttonLoginSubmit = driver.findElement(BUTTON_LOGIN_SUBMIT);
        return buttonLoginSubmit;
    }

    public void login() {
        open();
        wait.until(titleIs(loginTitle()));
        loginMenuItem().click();
        enterLoginUsername();
        enterLoginPassword();
        buttonLoginSubmit().click();
        new Actions(driver).click().perform();
    }

    public By labelLoggedUsername() {
        return LABEL_LOGGED_USER_NAME;
    }

    public String getTextOfLabelLoggedUsername() {
        String getTextOfLabelLoggedUsername = driver.findElement(LABEL_LOGGED_USER_NAME).getText();
        return getTextOfLabelLoggedUsername;
    }

    public WebElement linkLogoutMenuItem() {
        WebElement linkLogoutMenuItem = driver.findElement(LINK_LOGOUT_MENU_ITEM);
        return linkLogoutMenuItem;
    }

    public WebElement buttonLogout() {
        WebElement buttonLogout = driver.findElement(BUTTON_LOGOUT);
        return buttonLogout;
    }

    public String getTextOfLabelLoggedOut() {
        String getTextOfLabelLoggedOut = driver.findElement(LABEL_BUTTON_LOGOUT).getText();
        return getTextOfLabelLoggedOut;
    }

    public void screenshotMaking() {
        File screenshotTaken = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
            String dateStamp = simpleDateFormat.format(new Date(System.currentTimeMillis()));
            FileUtils.copyFile(screenshotTaken, new File("src/test/resources/" + dateStamp + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}