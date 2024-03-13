package TestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    //Declare driver (untuk open browser)
    //ThreadLocal = library
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<>();
    @BeforeMethod //utk nandain bagian ini dulu yg di execute
    public void openBrowser(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        // add setter and getter
        driver.set(new FirefoxDriver(options));
        driver.get().manage().window().maximize(); //Maximize window
        driver.get().get("https://demoblaze.com");
        //wait until 120s
        explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(120)));
    }

    @AfterMethod //
    public void closeBrowser(){
        driver.get().quit();

    }
}
