import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class InstaBot {

    private static final String WEB_DRIVER = "webdriver.chrome.driver";
    private static final String WINDOWS_WEB_DRIVER_PATH = ".\\driver\\chromedriver.exe";
    private static final String MAC_WEB_DRIVER_PATH = "driver/chromedriver";

    private static final String USER_NAME = "juan.baragli@gmail.com";
    private static final String PASSWORD = "test123";

    private static final String HASH_TAG = "#foodporn";
    private static final String COMMENT = "Cooool!";

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(WEB_DRIVER, MAC_WEB_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//        removeFollowings();
        followUsersWhoLikedThePosts();
//        commentPosts();
//        likePosts();
//        likePostsAndCommentPostsAndFollowUsersWhoLikedThePosts();
    }

    private static void removeFollowings() throws InterruptedException {
        new HomePage(driver)
                .openLogin()
                .loginWithPassword(USER_NAME, PASSWORD)
                .openProfilePage()
                .openFollowing()
                .removeFollowings();
    }

    private static void likePostsAndCommentPostsAndFollowUsersWhoLikedThePosts() throws InterruptedException {
        new HomePage(driver)
                .openLogin()
                .loginWithPassword(USER_NAME, PASSWORD)
                .searchByHashTag(HASH_TAG)
                .likePostsAndCommentPostsAndFollowUsersWhoLikedThePosts(COMMENT);
    }

    private static void likePosts() throws InterruptedException {
        new HomePage(driver)
                .openLogin()
                .loginWithPassword(USER_NAME, PASSWORD)
                .searchByHashTag(HASH_TAG)
                .likePosts();
    }

    private static void commentPosts() throws InterruptedException {
        new HomePage(driver)
                .openLogin()
                .loginWithPassword(USER_NAME, PASSWORD)
                .searchByHashTag(HASH_TAG)
                .commentPosts(COMMENT);
    }

    private static void followUsersWhoLikedThePosts() throws InterruptedException {
        new HomePage(driver)
                .openLogin()
                .loginWithPassword(USER_NAME, PASSWORD)
                .searchByHashTag(HASH_TAG)
                .followUsersWhoLikedThePosts();
    }
}
