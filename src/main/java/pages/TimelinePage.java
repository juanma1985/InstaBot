package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimelinePage {
    private final WebDriver driver;

    public TimelinePage(WebDriver driver) {
        this.driver = driver;
        closeNotificationPopUp();
    }

    private void closeNotificationPopUp() {
        WebElement notNowNotificationsButton = driver.findElement(By.cssSelector("button.HoLwm"));
        notNowNotificationsButton.click();
    }

    public HashTagResultPage searchByHashTag(String hashTag) throws InterruptedException {
        return new SearchComponent(driver).searchByHashTag(hashTag);
    }

    public SearchComponent searchByUserName(String name) throws InterruptedException {
        return new SearchComponent(driver).searchByUserName(name);
    }

    public ProfilePage openProfilePage() {
        WebElement profileButton = driver.findElement(By.xpath("//span[@aria-label='Profile']"));
        profileButton.click();

        return new ProfilePage(driver);
    }
}
