package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class PopUp {
    public SelenideElement thanksText = $("#example-modal-sizes-title-lg");

    SelenideElement table = $(By.tagName("tbody"));
    public List<SelenideElement> valueTd = table.$$("td:nth-child(2)");
}
