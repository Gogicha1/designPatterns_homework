package PageFactory.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PopUpPages {
    WebDriver driver;

    @FindBy(css = "div[class= 'content-header'] p:nth-child(1)")
    public WebElement popUpName;

    @FindBy(css = "div[class= 'content-header'] p:nth-child(2)")
    public WebElement popUpLocationName;

    @FindBy(xpath = "//div[@class= 'content-header']//p[3]")
    public WebElement checkData;

    @FindBy(css = "div.seat.free")
    public WebElement freeSeat;

    public PopUpPages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10) , this);
    }


}
