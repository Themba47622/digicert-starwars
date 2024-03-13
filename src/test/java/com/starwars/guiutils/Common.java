package com.starwars.guiutils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Common {
    public static WebElement waitForClickableElement(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForElementVisibility(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static boolean isTextPresentInList(WebElement el, String text) {
        List<WebElement> liElements = el.findElements(By.tagName("li"));
        for (WebElement li : liElements) {
            if (li.getText().equals(text)) {
                return true;
            }
        }
        return false;
    }

    public static String getTextFromLastRow(WebElement lastRow) {
        WebElement tdElement = lastRow.findElement(By.tagName("td"));
        return tdElement.getText();
    }
}
