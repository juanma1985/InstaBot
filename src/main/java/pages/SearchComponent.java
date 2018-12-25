package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchComponent {
    private final WebDriver driver;

    public SearchComponent(WebDriver driver) {
        this.driver = driver;
    }

    public HashTagResultPage searchByHashTag(String hashTag) throws InterruptedException {
        search(hashTag);
        String xpathExpression = "//a[@href='/explore/tags/" + hashTag.split("#")[1] + "/']";
        WebElement searchResult = driver.findElement(By.xpath(xpathExpression));
        searchResult.click();

        return new HashTagResultPage(driver);
    }

    public SearchComponent searchByUserName(String name) throws InterruptedException {
        search(name);
        String[] split = name.split("@");
        String userName = split.length > 1 ? split[1] : name;
        String xpathExpression = "//a[@href='/" + userName + "/']";
        WebElement searchResult = driver.findElement(By.xpath(xpathExpression));
        searchResult.click();

        return this;
    }

    private void search(String text) throws InterruptedException {
        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchField.sendKeys(text);

        Thread.sleep(1000);
    }
}
