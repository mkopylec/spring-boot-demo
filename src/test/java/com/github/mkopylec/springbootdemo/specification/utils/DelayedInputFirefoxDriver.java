package com.github.mkopylec.springbootdemo.specification.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.String.valueOf;
import static java.lang.Thread.sleep;
import static org.openqa.selenium.By.id;

public class DelayedInputFirefoxDriver extends FirefoxDriver {

    public void enterTextIntoElement(String elementId, String text) throws InterruptedException {
        WebElement element = findElement(id(elementId));
        element.clear();
        for (char character : text.toCharArray()) {
            element.sendKeys(valueOf(character));
            sleep(300);
        }
    }

    public void clickElement(String elementId) {
        findElement(id(elementId)).click();
    }

    public String getElementText(String elementId) {
        return findElement(id(elementId)).getText();
    }

    public void clearElementText(String elementId) {
        findElement(id(elementId)).clear();
    }

    public void wait(int seconds) throws InterruptedException {
        sleep(seconds * 1000);
    }
}
