package TestCase;

import io.qameta.allure.Description;
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

}