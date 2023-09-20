package Steps;

import Data.RegisterData;
import Pages.PracticeForms;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormsSteps {
    PracticeForms practiceForms = new PracticeForms();
    RegisterData registerData = new RegisterData();

    @Step
    public PracticeFormsSteps setUserName(){
        practiceForms.nameItem.setValue(registerData.userName);
        return this;
    }

    @Step
    public PracticeFormsSteps setLastName(){
        practiceForms.lastNameItem.setValue(registerData.lastName);
        return this;
    }

    @Step
    public PracticeFormsSteps setGender(){
        executeJavaScript("arguments[0].click()", practiceForms.gender);
        return this;
    }

    @Step
    public PracticeFormsSteps setMobileNumber(){
        practiceForms.mobileNumberItem.setValue(registerData.mobileNumber);
        return this;
    }

    @Step
    public void formSubmit(){
        executeJavaScript("arguments[0].click()", practiceForms.submitButton);
    }
}
