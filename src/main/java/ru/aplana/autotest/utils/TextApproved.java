package ru.aplana.autotest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.annotation.Nullable;
import java.util.function.Function;

public class TextApproved implements ExpectedCondition<Boolean> {
    String expectedText;
    WebElement element;

    public TextApproved(String expectedText, WebElement element)
    {
        this.expectedText = expectedText;
        this.element = element;
    }

    public Boolean apply(WebDriver driver)
    {
        Boolean isTextFieldCorrect = element.getAttribute("value").replaceAll("[^\\d.]", "").equals(expectedText);
        if(!isTextFieldCorrect)
        {
            element.clear();
            element.sendKeys(expectedText);
        }
        return isTextFieldCorrect;
    }
}
