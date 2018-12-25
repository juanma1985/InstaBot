package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public TimelinePage loginWithPassword(String userName, String password) {
        WebElement emailField = driver.findElement(By.xpath("//input[@name='username']"));
        emailField.sendKeys(userName);

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        return new TimelinePage(driver);
    }
}
