package com.yoda.yodale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class Config {

    @Value("pathToChromeData")
    private static String pathToChromeData;

    @Value("pathToChromeDriver")
    private static String pathToChromeDriver;

    @Value("currentDir")
    private static String currentDir;

    //promjena u chromium !!!!!!
    public static WebDriver getDriver() {
        pathToChromeData = "user-data-dir=" + pathToChromeData;
        System.out.println("pathToChromeData: "  + pathToChromeData);

        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/chromium-browser");
        options.addArguments(pathToChromeData); //#Path to your chrome profile
        //options.setBinary(pathToChromeDriver);
        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Galaxy S5");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
/*        options.addArguments("--headless");
        options.addArguments("--disable-gpu");*/
        //options.addArguments("--no-sandbox");
        //options.addArguments("--disable-dev-shm-usage");
        //options.setBinary("/usr/bin/google-chrome");
       // System.setProperty("webdriver.firefox.marionette","/home/luce/Programs/Drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver",pathToChromeDriver);
        WebDriver driverc  = new ChromeDriver(options);
        //this.driverf = new FirefoxDriver();
        return driverc;
    }


    public String getPathToChromeData() {
        return pathToChromeData;
    }

    public void setPathToChromeData(String pathToChromeData) {
        this.pathToChromeData = pathToChromeData;
    }

    public static String getPathToChromeDriver() {
        return pathToChromeDriver;
    }

    public  void setPathToChromeDriver(String pathToChromeDriver) {
        this.pathToChromeDriver = pathToChromeDriver;
    }

    public static  String getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(String currentDir) {
        this.currentDir = currentDir;
    }
}
