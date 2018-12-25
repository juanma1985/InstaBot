package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfilePage {
    private final WebDriver driver;
    private int followingsRemoved = 0;
    private int followingsCount;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        followingsCount = Integer.parseInt(getFollowingButton().findElement(By.tagName("span")).getText());
    }

    public ProfilePage openFollowing() throws InterruptedException {
        WebElement followingButton = getFollowingButton();
        followingButton.click();

        Thread.sleep(500);

        return this;
    }

    private WebElement getFollowingButton() {
        String name = driver.findElement(By.xpath("//h1[@class='_7UhW9       fKFbl yUEEX   KV-D4            fDxYl     ']")).getText();
        String xpathExpression = "//a[@href='/" + name + "/following/']";
        return driver.findElement(By.xpath(xpathExpression));
    }

    public ProfilePage removeFollowings() throws InterruptedException {
        List<WebElement> followings = driver.findElements(By.xpath("//button[@class='_0mzm- sqdOP  L3NKy   _8A5w5    ']"));
        for (WebElement following : followings) {
            following.click();
            followingsRemoved++;
            Thread.sleep(1000);
        }
        if (followingsRemoved < followingsCount) {
            removeFollowings();
        }
        return this;
    }

}
