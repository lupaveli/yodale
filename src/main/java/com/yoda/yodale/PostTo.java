package com.yoda.yodale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.IRobot;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
//import org.seleniumhq.selenium.common.action_chains¶


import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Key;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class PostTo {


    String currentDir ;

    String pathToFile = "";
    String picUrl = "";
    String picname = "";
    Screen s;
    String IMGLISTFILE = "imglistg";

    Pattern postButton = new Pattern("/home/luce/Pictures" + "postButton.png");
    Pattern openButton = new Pattern("/home/luce/Pictures" + "openButton.png");

    String pictureText;

    public PostTo() {
        currentDir =  Config.getCurrentDir();
        this.picUrl = readImgList();//"https://i.imgur.com/3nYhEKH.jpg"; //
        this.picname = picUrl.substring(picUrl.lastIndexOf("/") + 1);
        String path = getPathToFile(this);

    }

    String baseUrl = "https://instagram.com";

    String actualTitle = "";

    public void prepareForPost(PostTo st){

        WebDriver chrdriver = Config.getDriver();
        sleep();
        sleep();sleep();

        chrdriver.navigate().to(baseUrl);
        actualTitle = chrdriver.getTitle();

        postPic(chrdriver, st);
        sleep();sleep();
        chrdriver.quit();
    }


//    public void clickItem(String imageNameOrText, Locator locator) {
//
//        imageNameOrText = locator.updateLocatorTarget(imageNameOrText);
//        try {
//
//            if (locator.isImage()) {
//                Helper.getRegion().click(new Pattern(imageNameOrText).similar(locator.getSimilarityasFloat())
//                        .targetOffset(locator.getxOffset(), locator.getyOffset()));
//            } else if (locator.isText()) {
//                Location location = new TextRecognizer().findText(imageNameOrText);
//                Helper.getRegion().click(new Location(location.x + (double)locator.getxOffset(),
//                        location.y + (double)locator.getyOffset()));
//            }
//        } catch (FindFailed e) {
//            this.handleFindFailed(locator.isRemote(), e);
//        }
//    }

    public static void postPic(WebDriver driver, PostTo st){
        // ********** postavi developer tools i refreshaj
        System.setProperty("java.awt.headless", "false");
        String var0 = System.getProperty("java.awt.headless");
        Screen s = new Screen();

        s.getRobot();
        s.initScreen(s);
        Pattern postButton = new Pattern("/home/luce/Pictures" + "postButton.png");
        Pattern openButton = new Pattern("/home/luce/Pictures" + "openButton.png");

        WebElement bLogin =  (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-root\"]/section/nav[2]/div/div/div[2]/div/div/div[3]/span[@aria-label='New Post']")));
        try{
//            Helper.getRegion().click(new Pattern(imageNameOrText).similar(locator.getSimilarityasFloat())
//                    .targetOffset(locator.getxOffset(), locator.getyOffset()));
            s.click("imgs/postButton.png");
        }catch (Exception e){
            e.printStackTrace();
        }

        //driver.execute_script("window.scrollTo(0, Y)")
        WebElement post = driver.findElement(By.cssSelector("span#react-root > section[class='_9eogI E3X2T'] > nav[class='NXc7H  f11OC '] > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(3) > span[class='glyphsSpriteNew_post__outline__24__grey_9 u-__7']"));
        //bLogin =  driver.findElement(By.cssSelector("//#react-root > section > nav.NXc7H.f11OC > div > div > div.KGiwt > div > div > div.q02Nz._0TPg > span"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", post);



        WebElement newPost = driver.findElement(By.xpath("//span[@aria-label='New Post']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", newPost);
        newPost.click();

//        driver.findElement(By.cssSelector("span#react-root > section[class='_9eogI E3X2T'] > nav[class='NXc7H  f11OC '] > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(3) > span[class='glyphsSpriteNew_post__outline__24__grey_9 u-__7']")).sendKeys(Keys.ENTER);
//        driver.findElement(By.name("New Post")).sendKeys(Keys.RETURN);
//        driver.findElement(By.xpath("//span[@aria-label='New Post']")).sendKeys(Keys.RETURN);
//        ActionChains

/*        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", bLogin);
        bLogin.sendKeys(Keys.ENTER);*/

/*        WebElement bLogin =  driver.findElement(By.cssSelector("span.glyphsSpriteNew_post__outline__24__grey_9<SP>u-__7&&ARIA-LABEL:New<SP>Post"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", bLogin);
        bLogin.sendKeys(Keys.ENTER);*/

//         bLogin =  driver.findElement(By.xpath("//span[@id='react-root']/section/nav[2]/div/div/div[2]/div/div/div[3]/span"));
//        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", bLogin);
//        bLogin.click();


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

        e5.sendKeys(st.getPictureText() +  "\n \n #spiritbearwear #geometricart #geometric # petlove  #geometriclove #art #tattoolovers #geometrictattoos  ");
        sleep();



        e5 = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/div[1]/header/div/div[2]/button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", e5);
        sleep();sleep();sleep();sleep();
        sleep();sleep();sleep();sleep();
        sleep();sleep();sleep();sleep();
        sleep();sleep();sleep();sleep();


        System.out.println("Done");




    }

    public static void sleep(){
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getPathToFile(PostTo st) {

        try{
            //currentDir = Config.getCurrentDir();
            st.setPathToFile(currentDir+ st.picname);

            Document document = Jsoup.connect("https://"+picUrl
                    .replace(".jpg","")
                    .replace(".mp4","")
                    .replace(".gif","")
                    .replace(".png",""))
                    .timeout(60000/*wait up to 60 sec for response*/)
                    .get();

            st.setPictureText(document.title().replace("- Imgur",""));
            InputStream input = new URL("https://"+picUrl.replace("/gallery", "")).openStream();

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
                    currentDir + IMGLISTFILE));
            line = reader.readLine();
            tmpline = line;

            File imglist = new File(currentDir + IMGLISTFILE);
            Scanner fileScanner = new Scanner(imglist);
            reader.close();
            String next = fileScanner.nextLine();
            FileWriter fileStream = new FileWriter(currentDir + IMGLISTFILE);
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
