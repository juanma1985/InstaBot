package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HashTagResultPage {

    private static final int POSTS_THRESHOLD = 5;
    private static final int USERS_THRESHOLD = 10;

    private List<WebElement> posts;

    public HashTagResultPage(WebDriver driver) {
        posts = driver.findElements(By.cssSelector(".v1Nh3"));
    }

    public HashTagResultPage likePostsAndCommentPostsAndFollowUsersWhoLikedThePosts(String comment) throws InterruptedException {
        int count = 0;
        for (WebElement post : posts) {
            if (count < POSTS_THRESHOLD) {
                post.click();
                likePost(post);
                commentPost(post, comment);
                openLikeList(post);
                followUsers(post);
                count++;
            }
        }
        return this;
    }

    public HashTagResultPage followUsersWhoLikedThePosts() throws InterruptedException {
        int count = 0;
        for (WebElement post : posts) {
            if (count < POSTS_THRESHOLD) {
                post.click();
                openLikeList(post);
                followUsers(post);
                count++;
            }
        }
        return this;
    }

    public HashTagResultPage likePosts() throws InterruptedException {
        int count = 0;
        for (WebElement post : posts) {
            if (count < POSTS_THRESHOLD) {
                post.click();
                likePost(post);
                count++;
            }
        }
        return this;
    }

    public HashTagResultPage commentPosts(String comment) throws InterruptedException {
        int count = 0;
        for (WebElement post : posts) {
            if (count < POSTS_THRESHOLD) {
                post.click();
                commentPost(post, comment);
                count++;
            }
        }
        return this;
    }

    private void commentPost(WebElement post, String comment) throws InterruptedException {
        try {
            WebElement commentField = post.findElement(By.xpath("//textarea[@aria-label='Add a comment…']"));
            commentField.sendKeys(comment);
        } catch (Exception e) {
            WebElement commentField = post.findElement(By.xpath("//textarea[@aria-label='Add a comment…']"));
            commentField.sendKeys(comment);
            commentField.sendKeys(Keys.ENTER);
        }
        Thread.sleep(900);
    }

    private void followUsers(WebElement post) throws InterruptedException {
        List<WebElement> followButtons = post.findElements(By.xpath("//button[@class='_0mzm- sqdOP  L3NKy       ']"));
        int count = 0;
        for (WebElement followButton : followButtons) {
            if (count < USERS_THRESHOLD) {
                followButton.click();
                Thread.sleep(1000);
                count++;
            }
        }
        closePost(post);
    }

    private void openLikeList(WebElement post) throws InterruptedException {
        WebElement likeListButton = post.findElement(By.xpath("//button[@class='_0mzm- sqdOP yWX7d    _8A5w5    ']"));
        likeListButton.click();
        Thread.sleep(1000);
    }

    private void closePost(WebElement post) throws InterruptedException {
        WebElement closeButton = post.findElement(By.xpath("//button[@class='ckWGn']"));
        closeButton.click();
        Thread.sleep(1000);
    }

    private void likePost(WebElement post) throws InterruptedException {
        try {
            WebElement likeButton = post.findElement(By.xpath("//span[@aria-label='Like']"));
            likeButton.click();
        } catch (Exception e) {
            // do nothing
        }
        Thread.sleep(1000);
        closePost(post);
    }

}