import WithoutPageFactory.Steps.FirstSteps;
import WithoutPageFactory.Steps.MovieSteps;
import WithoutPageFactory.Steps.PopSteps;
import WithoutPageFactory.Steps.SectionsSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SwoopTestWithoutFactory {
    WebDriver driver;

    FirstSteps firstSteps;

    MovieSteps movieSteps;

    SectionsSteps sectionsSteps;
    PopSteps popSteps;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void SwoopTestWithoutFactory(){
        firstSteps = new FirstSteps(driver);
        movieSteps = new MovieSteps(driver);
        sectionsSteps = new SectionsSteps(driver);
        popSteps = new PopSteps(driver);
        driver.get("https://www.swoop.ge/");
        firstSteps.clickOnMovie();
        movieSteps.checkAndBuy();
        sectionsSteps.clickOnLastDay().checkEastPoint().clickOnLastSeance();
        popSteps.checkValidity().clickOnFreeSeat();

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
