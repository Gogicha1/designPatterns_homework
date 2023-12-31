package PageFactory.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class MoviesPage {
    WebDriver driver;

    @FindBy(xpath = "(//div[@class='movies-deal'])")
    public List<WebElement> allMovies;

    @FindBy(xpath = ".//p[text()='ყიდვა']")
    public WebElement buy;
    public MoviesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }



}
