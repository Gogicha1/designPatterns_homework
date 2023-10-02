package PageFactory.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

//    private static String PAGE_URL=;

    @FindBy(xpath = "//div[@class='Menus']//a[contains(@href, '/events')]")
    public WebElement movieButton;

    public MainPage(WebDriver driver){
        this.driver = driver;
        driver.get("https://www.swoop.ge/");
        PageFactory.initElements(driver, this);
    }


}
