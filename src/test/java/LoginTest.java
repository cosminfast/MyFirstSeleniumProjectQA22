import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginWithValidCredentials() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        WebElement welcomeText = driver.findElement(By.cssSelector(".hello strong"));
        Assert.assertEquals("Hello, Cosmin Fast!", welcomeText.getText());
        Assert.assertTrue(welcomeText.isDisplayed());

    }

    @Test
    public void loginWithInvalidPassword() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123123123");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        WebElement errorTextElement = driver.findElement(By.cssSelector(".error-msg span"));
        Assert.assertEquals("Invalid login or password.", errorTextElement.getText());
    }
    @Test
    public void loginWithoutMandatoryFields() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        WebElement emailErrorMessage = driver.findElement(By.id("advice-required-entry-email"));
        Assert.assertEquals("This is a required field.", emailErrorMessage.getText());
        WebElement passwordErroMessage = driver.findElement(By.id("advice-required-entry-pass"));
        Assert.assertEquals("This is a required field.", passwordErroMessage.getText());
    }

    @After
    public void close() {
        driver.quit();
    }

}
