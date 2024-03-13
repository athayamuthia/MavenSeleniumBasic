package TestCase;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProduct extends BaseTest {

    @Test(priority = 1)
    @Description("Assert price")
    public void getPrice(){

        //Tes dan Assert harga smart phone Samsung Galaxy s6
        WebElement phonesCat = driver.get().findElement(By.xpath("//a[.='Phones']"));
        phonesCat.click();

        WebElement samsung = driver.get().findElement(By.xpath("//a[.='Samsung galaxy s6']"));
        samsung.click();

        //Assert or Validate Price
        WebElement price = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='price-container']")));
        Assert.assertTrue(price.getText().contains("$360"));
    }


    @Test(priority = 2)
    @Description("Test Description: Sign Up functionality check.")
    public void testSignUp() {
        driver.get().findElement(By.xpath("//a[.='Sign up']")).click();
        explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        driver.get().findElement(By.id("sign-username")).sendKeys("Fuy");
        driver.get().findElement(By.id("sign-password")).sendKeys("hohoho123");
        driver.get().findElement(By.xpath("//button[.='Sign up']")).click();
        Alert alert = explicitWait.get().until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        Assert.assertTrue(alertMessage.equals("Sign up successful.") || alertMessage.equals("This user already exist."), "Alert message was not as expected: " + alertMessage);
        alert.accept();
    }

    @Test(priority = 3)
    @Description("Add to cart")
    public void addCart() {
        //Tes dan Assert harga smart phone Samsung Galaxy s6
        WebElement phonesCat = driver.get().findElement(By.xpath("//a[.='Phones']"));
        phonesCat.click();
        WebElement samsung = driver.get().findElement(By.xpath("//a[.='Samsung galaxy s6']"));
        samsung.click();
        WebElement addtoCart = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Add to cart']")));
        addtoCart.click();
        //menunggu alertnya muncul
        Alert alert = explicitWait.get().until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        Assert.assertTrue(alertMessage.equals("Product added"));
        alert.accept();
        //ke menu cart
        driver.get().findElement(By.xpath("//a[@id='cartur']")).click();
        // cek phone added to chart
        WebElement cartTable = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[.='Samsung galaxy s6']")));
        Assert.assertTrue(cartTable.getText().contains("Samsung galaxy s6"), "phone not found in cart.");
    }

}