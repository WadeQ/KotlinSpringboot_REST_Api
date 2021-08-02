package com.wadektech.springkotlindemo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class ElementFetch {

    public WebElement getWebElement(String  identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return Objects.requireNonNull(SeleniumApiTest.Constants.getDriver()).findElement(By.id(identifierValue));
            case "CSS":
                return Objects.requireNonNull(SeleniumApiTest.Constants.getDriver()).findElement(By.cssSelector(identifierValue));
            case "TAGNAME":
                return Objects.requireNonNull(SeleniumApiTest.Constants.getDriver()).findElement(By.tagName(identifierValue));
            case "XPATH":
                return Objects.requireNonNull(SeleniumApiTest.Constants.getDriver()).findElement(By.xpath(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getListOfWebElement(String  identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return Objects.requireNonNull(SeleniumApiTest.Constants.getDriver()).findElements(By.id(identifierValue));
            case "CSS":
                return Objects.requireNonNull(SeleniumApiTest.Constants.getDriver()).findElements(By.cssSelector(identifierValue));
            case "TAGNAME":
                return Objects.requireNonNull(SeleniumApiTest.Constants.getDriver()).findElements(By.tagName(identifierValue));
            case "XPATH":
                return Objects.requireNonNull(SeleniumApiTest.Constants.getDriver()).findElements(By.xpath(identifierValue));
            default:
                return null;
        }
    }
}
