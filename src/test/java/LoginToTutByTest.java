import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginToTutByTest extends BeforeAfter {
    @Test
    public void loginSuccessful() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login();
        wait.until(ExpectedConditions.presenceOfElementLocated(loginPage.labelLoggedUsername()));
        assertEquals("Selenium Test", loginPage.getTextOfLabelLoggedUsername());
    }
}