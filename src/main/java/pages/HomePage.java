package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        driver.navigate().to("https://www.instagram.com");
        setEnglishLanguage();
    }

    public LoginPage openLogin() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.linkText("Log in"));
        loginButton.click();

        Thread.sleep(1000);

        return new LoginPage(driver);
    }

    private void setEnglishLanguage() throws InterruptedException {
        WebElement languageButton = driver.findElement(By.cssSelector("ul.ixdEe li:last-child"));
        languageButton.click();

        WebElement englishLanguage = driver.findElement(By.xpath("//option[@value='en']"));
        englishLanguage.click();

        Thread.sleep(1000);
    }
}
