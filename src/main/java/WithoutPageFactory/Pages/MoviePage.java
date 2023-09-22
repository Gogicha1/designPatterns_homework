package WithoutPageFactory.Pages;

import PageFactory.Pages.MoviesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MoviePage {
    WebDriver driver;

    public MoviePage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getMovies(){
        return driver.findElements(By.xpath("(//div[@class='movies-deal'])"));
    }

    public WebElement buyButton(){
        return driver.findElement(By.xpath(".//p[text()='ყიდვა']"));
    }
}
