package PageFactory.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MoviesSectionPage {
    WebDriver driver;

    @FindBy(xpath = "//li/a[text()='კავეა ისთ ფოინთი']")
    public WebElement eastPoint;

    @FindBy(css = "div[aria-expanded = true] div ul li:last-child a")
    public WebElement date;

    @FindBy(xpath = "//div[@id='384933']//div[@class='seanse-details ui-tabs-panel ui-widget-content ui-corner-bottom']//p[@class='cinema-title' and text()='კავეა ისთ ფოინთი']")
    public List<WebElement> eastPointSeances;

    @FindBy(css = "div.info p.name")
    public WebElement movieName;

    @FindBy(css = "div[class*='ui-tabs-panel'][aria-hidden=false] div[class*='seanse-details'] a ")
    public List<WebElement> time;


    public MoviesSectionPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
