package WithoutPageFactory.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SectionsPage {
    WebDriver driver;

    public SectionsPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement returnEastPoint(){
        return driver.findElement(By.xpath("//li/a[text()='კავეა ისთ ფოინთი']"));
    }

    public WebElement returnData(){
        return driver.findElement(By.cssSelector("div[aria-expanded = true] div ul li:last-child a"));
    }

    public List<WebElement> returnSeances() {
        return driver.findElements(By.xpath("//div[@id='384933']//div[@class='seanse-details ui-tabs-panel ui-widget-content ui-corner-bottom']//p[@class='cinema-title' and text()='კავეა ისთ ფოინთი']"));
    }
    public WebElement returnMovieName(){
        return driver.findElement(By.cssSelector("div.info p.name"));
    }
    public List<WebElement> returnTime(){
        return driver.findElements(By.cssSelector("div[class*='ui-tabs-panel'][aria-hidden=false] div[class*='seanse-details'] a"));
    }
}

