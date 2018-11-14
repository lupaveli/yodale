package com.yoda.yodale;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class NewTab {
 /*   *//**
     * Executes a script on an element
     * @note Really should only be used when the web driver is sucking at exposing
     * functionality natively
     * @param script The script to execute
     * @param element The target of the script, referenced as arguments[0]
     *//*
    public void trigger(String script, WebElement element, WebDriver driver) {
        ((JavascriptExecutor)driver).executeScript(script, element);
    }

    *//** Executes a script
     * @note Really should only be used when the web driver is sucking at exposing
     * functionality natively
     * @param script The script to execute
     *//*
    public Object trigger(String script, WebDriver driver) {
        return ((JavascriptExecutor)driver).executeScript(script);
    }

    *//**
     * Opens a new tab for the given URL
     * @param picUrl The URL to
     * @throws JavaScriptException If unable to open tab
     *//*
    public void openTab(String picUrl) {
        String script = "var d=document,a=d.createElement('a');a.target='_blank';a.href='%s';a.innerHTML='.';d.body.appendChild(a);return a";
        Object element = trigger(String.format(script, picUrl));
        if (element instanceof WebElement) {
            WebElement anchor = (WebElement) element; anchor.click();
            trigger("var a=arguments[0];a.parentNode.removeChild(a);", anchor);
        } else {
            throw new Exception(element, "Unable to open tab", 1);
        }
    }


    //Next, you need to tell webdriver to switch its current window handle to the new tab. Here's how I do that:
    *//**
     * Switches to the non-current window
     *//*
    public void switchWindow(WebDriver driver) throws NoSuchWindowException, NoSuchWindowException {
        Set<String> handles = driver.getWindowHandles();
        String current = driver.getWindowHandle();
        handles.remove(current);
        String newTab = handles.iterator().next();
        locator.window(newTab);
    }*/
}
