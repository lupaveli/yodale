package com.yoda.yodale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.TimeUnit;


@ComponentScan
public class PostTo {
    String pathToFile;
    CharSequence pathfile = pathToFile;


    //WebDriver driver = new FirefoxDriver();
    //comment the above 2 lines and uncomment below 2 lines to use Chrome

    String baseUrl = "https://instagram.com";

    String actualTitle = "";

    public void prepareForPost(PostTo st){

        WebDriver chrdriver = Config.getDriver();
        sleep();sleep();sleep();sleep();
        sleep();sleep();sleep();sleep();

        chrdriver.navigate().to(baseUrl);
        actualTitle = chrdriver.getTitle();


        //loginInsta(chrdriver);
        postPic(chrdriver, st);

        sleep();sleep();sleep();sleep();
        //close Fire fox
        chrdriver.close();
    }




    public static void postPic(WebDriver driver, PostTo st){
        // ********** postavi developer tools i refreshaj



        WebElement bLogin =  (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-root\"]/section/nav[2]/div/div/div[2]/div/div/div[3]/span")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", bLogin);


        WebElement e2 = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/nav[2]/div/div/form/input"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", e2);
        sleep();

        e2.sendKeys(st.getPathToFile());
        sleep();

        WebElement e3 = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/div[2]/div[2]/div/div/div/button[1]/span"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", e3);

        WebElement e4 = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/div[1]/header/div/div[2]/button"));//xpath("//*[@id=\"react-root\"]/section/div[1]/header/div/div[2]/button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", e4);
        sleep();


        WebElement e5 = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/div[1]/header/div/div[2]/button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", e5);

        System.out.println("Done");





//   //*[@id="react-root"]/section/nav[2]/div/div/div[2]/div/div/div[3]/span
/*#react-root > section > nav.NXc7H.f11OC > div > div > div.KGiwt > div > div > div.q02Nz._0TPg > span
                <span class="glyphsSpriteNew_post__outline__24__grey_9 u-__7" aria-label="New Post"></span>
                */
    }

    public static void sleep(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }
}
