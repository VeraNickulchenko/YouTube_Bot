import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter the name of song:");
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement search = driver.findElement(By.xpath("//input[@id = 'search']"));
        search.sendKeys(num);
        search.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//yt-formatted-string[text()='Filters']")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a/div/yt-formatted-string[text()='По числу просмотров']")).click();
        JavascriptExecutor jsq = (JavascriptExecutor)driver;
        jsq.executeScript("window.open()");
        List<String> wh = new ArrayList<>(driver.getWindowHandles());
         System.out.println(wh);
        driver.switchTo().window(wh.get(1));
        driver.navigate().to("https://generator-online.com/numbers/");
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//button[text() = 'Allow Selected']")).click();
        //driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        WebElement max = driver.findElement(By.xpath("//input[@id = 'nummax']"));
        max.click();
        max.sendKeys(Keys.BACK_SPACE);
        max.sendKeys(Keys.BACK_SPACE);
        max.sendKeys("5");
        driver.findElement(By.xpath("//button[text() = 'Генерировать результат']")).click();
        WebElement result = driver.findElement(By.xpath("//div[@id = 'resgen']"));
        String index =   result.getText();
        driver.close();
        int i=Integer.parseInt(index);
        driver.switchTo().window(wh.get(0));
        List<WebElement> adds = driver.findElements(By.xpath("//yt-formatted-string[@class = 'style-scope ytd-video-renderer']"));
        adds.get(i).click();





        /*
        driver.switchTo().window(wh.get(2));
        driver.navigate().to("https://www.google.com.ua/?hl=ru");
         */













       // List<WebElement> adds = driver.findElements(By.xpath("yt-formatted-string[@class='style-scope ytd-video-renderer']"));
       /* driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        JavascriptExecutor jsq = (JavascriptExecutor)driver;
        jsq.executeScript("window.open()");
        List<String> wh = new ArrayList<>(driver.getWindowHandles());
        System.out.println(wh);
        driver.switchTo().window(wh.get(1));
        driver.navigate().to("https://www.random.org/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id = 'true-random-integer-generator-button']")).click();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
       /* WebElement number = driver.findElement(By.xpath("//span[@id ='true-random-integer-generator-result']"));
        String index = number.getText();
        //int i=Integer.parseInt(index);


        /*
        driver.navigate().to("https://www.random.org/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement min =  driver.findElement(By.xpath("//input[@id ='true-random-integer-generator-min']"));
        min.sendKeys("1");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement max = driver.findElement(By.xpath("//input[@id ='true-random-integer-generator-max']"));
        max.sendKeys("100");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id ='true-random-integer-generator-button']")).click();
        WebElement number = driver.findElement(By.xpath("//span[@id ='true-random-integer-generator-result']"));
        String index = number.getText();
        int i=Integer.parseInt(index);
        adds.get(i).click();

         */








////yt-formatted-string[@class='style-scope ytd-video-renderer']






















































        //JavascriptExecutor jsq = (JavascriptExecutor)driver;
        //jsq.executeScript("window.open()");
        //List<String> wh = new ArrayList<>(driver.getWindowHandles());
        //System.out.println(wh);
        //driver.switchTo().window(wh.get(1));

        //driver.navigate().to("https://demo.opencart.com/index.php?route=common/home");
        //driver.close();
        //driver.switchTo().window(wh.get(0));
//        WebElement element = driver.findElement(By.name("q"));
//        element.sendKeys("MacBook");
//        element.sendKeys(Keys.ENTER);
       //List<WebElement> adds = driver.findElements(By.xpath("//h3[@class ='LC20lb DKV0Md']"));
//        for (WebElement e:adds) {
//            if(e.getText().contains("HOTLINE")){
//                e.click();
//                break;
//            }
//        }
//        driver.close();
//        System.out.println(driver);
//        driver.quit();
//        System.out.println(driver)
    }
}
