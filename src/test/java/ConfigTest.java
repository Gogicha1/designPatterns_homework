import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Configuration.timeout;

public class ConfigTest {
    @BeforeSuite
    public void configTests(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.browserSize = null;
        timeout=20000;
    }
}
