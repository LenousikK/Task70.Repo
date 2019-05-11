import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogOutTutByTest extends BeforeAfter {
    @Test
    public void logoutSuccessful() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login();
        loginPage.linkLogoutMenuItem().click();
        loginPage.buttonLogout().click();
        assertEquals("Войти", loginPage.getTextOfLabelLoggedOut());
        loginPage.screenshotMaking();
    }
}