package com.yoda.yodale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PostTo {


    String currentDir ;

    String pathToFile = "";
    String picUrl = "";
    String picname = "";

    String pictureText;

    public PostTo() {
        currentDir =  Config.getCurrentDir();
        this.picUrl = readImgList();//"https://i.imgur.com/3nYhEKH.jpg"; //
        this.picname = picUrl.substring(picUrl.lastIndexOf("/") + 1);

    }

    String baseUrl = "https://instagram.com";

    String actualTitle = "";

    public void prepareForPost(PostTo st){


        WebDriver chrdriver = Config.getDriver();
        sleep();
        sleep();sleep();sleep();sleep();

        chrdriver.navigate().to(baseUrl);
        actualTitle = chrdriver.getTitle();


        postPic(chrdriver, st);
        sleep();sleep();sleep();sleep();
        chrdriver.quit();
    }




    public static void postPic(WebDriver driver, PostTo st){
        // ********** postavi developer tools i refreshaj



        WebElement bLogin =  (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-root\"]/section/nav[2]/div/div/div[2]/div/div/div[3]/span")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", bLogin);


        WebElement e2 = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/nav[2]/div/div/form/input"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", e2);
        sleep();

        e2.sendKeys(st.getPathToFile(st));
        sleep();

        WebElement e3 = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/div[2]/div[2]/div/div/div/button[1]/span"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", e3);

        WebElement e4 = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/div[1]/header/div/div[2]/button"));//xpath("//*[@id=\"react-root\"]/section/div[1]/header/div/div[2]/button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", e4);
        sleep();

        WebElement e5 = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/div[2]/section[1]/div/textarea"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", e5);
        sleep();

        e5 = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/div[2]/section[1]/div/textarea"));

        e5.sendKeys(st.getPictureText() +  "\n  PetIDMe.com \n #petidme #cutepets #petid # petlove  #animaladdicts #dog #cute #dogood #catlove #cutedogs #dogslover #animallove #dogsrule #doga #dogstyle #adventuredog #dogsoninstagram #naturepic  #cutepuppies #doggylove #animali  ");
        sleep();



        e5 = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/div[1]/header/div/div[2]/button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", e5);

        System.out.println("Done");




    }

    public static void sleep(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getPathToFile(PostTo st) {

        try{
            //currentDir = Config.getCurrentDir();
            st.setPathToFile(currentDir+ st.picname);

            Document document = Jsoup.connect(picUrl.replace(".jpg","")).timeout(60000/*wait up to 60 sec for response*/).get();
            st.setPictureText(document.title().replace("- Imgur",""));
            InputStream input = new URL(picUrl).openStream();

            Files.copy(input, Paths.get(st.pathToFile), StandardCopyOption.REPLACE_EXISTING);

        }catch (Exception e){e.printStackTrace();}


        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String getPictureText() {
        return pictureText;
    }

    public void setPictureText(String pictureText) {
        this.pictureText = pictureText;
    }




    public String readImgList(){
        BufferedReader reader;
        String line = "";
        String tmpline = "";
        try {
            reader = new BufferedReader(new FileReader(
                    currentDir + "imglist"));
            line = reader.readLine();
            tmpline = line;

            File imglist = new File(currentDir + "imglist");
            Scanner fileScanner = new Scanner(imglist);
            reader.close();
            String next = fileScanner.nextLine();
            FileWriter fileStream = new FileWriter(currentDir + "imglist");
            BufferedWriter out = new BufferedWriter(fileStream);
            while(fileScanner.hasNextLine()) {
                 next = fileScanner.nextLine();
                if(next.equals("\n"))
                    out.newLine();
                else
                    out.write(next);
                out.newLine();
            }
            out.close();

            fileScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }
}
