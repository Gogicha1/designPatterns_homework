import PageFactory.Steps.MainPageSteps;
import PageFactory.Steps.MoviesSectionSteps;
import PageFactory.Steps.MoviesSteps;
import PageFactory.Steps.PopUpSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class SwoopTestPageFactory extends ConfigTest{

    private MainPageSteps mainPageSteps;
    private MoviesSteps moviesSteps;
    private MoviesSectionSteps moviesSectionSteps;
    private PopUpSteps popUpSteps;
    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void swoopTestPageFactory(){
        mainPageSteps = new MainPageSteps(driver);
        moviesSteps = new MoviesSteps(driver);
        moviesSectionSteps = new MoviesSectionSteps(driver);
        popUpSteps = new PopUpSteps(driver);

        mainPageSteps.clickOnMovieButton();
        moviesSteps.clickOnBuy();
        moviesSectionSteps.clickOnLastDate().checkEastPoint().clickOnLastOption();
        popUpSteps.checkEquality().clickOnFreeSeat();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
