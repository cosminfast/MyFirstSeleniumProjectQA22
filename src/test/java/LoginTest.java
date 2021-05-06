import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public void loginWithValidCredentials(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
//        WebElement element = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        element.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();


        driver.quit();
    }


}
