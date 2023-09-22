package WithoutPageFactory.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUpPage {
    WebDriver driver;

    public PopUpPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement returnPopUpName(){
        return driver.findElement(By.cssSelector("div[class= 'content-header'] p:nth-child(1)"));
    }

    public WebElement returnPopUpLocation(){
        return driver.findElement(By.cssSelector("div[class= 'content-header'] p:nth-child(2)"));
    }

    public WebElement returnPopUpData(){
        return driver.findElement(By.xpath("//div[@class= 'content-header']//p[3]"));
    }

    public WebElement returnFreeSeat(){
        return driver.findElement(By.cssSelector("div.seat.free"));
    }


}
