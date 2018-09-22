package com.yoda.yodale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Driver {



    public static WebDriver getDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/home/luce/.config/google-chrome/Default/"); //#Path to your chrome profile
        //options.setBinary("/usr/bin/google-chrome");
       // System.setProperty("webdriver.firefox.marionette","/home/luce/Programs/Drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver","/home/luce/Programs/Drivers/chromedriver");
        WebDriver driverc  = new ChromeDriver(options);
        //this.driverf = new FirefoxDriver();
        return driverc;
    }




}
