package WithoutPageFactory.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPage {
    WebDriver driver;

    public FirstPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getMovieButton(){
        return driver.findElement(By.xpath("//div[@class='Menus']//a[contains(@href, '/events')]"));
    }
}
