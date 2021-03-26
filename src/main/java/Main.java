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
        WebElement search = driver.findElement(By.xpath("//input[@id = 'search']"));
        search.sendKeys(num);
        search.sendKeys(Keys.ENTER);
        List<WebElement> adds = driver.findElements(By.xpath("//ytd-item-section-renderer"));
        driver.findElement(By.xpath("//yt-icon[@class='style-scope ytd-toggle-button-renderer']")).click();
        driver.findElement(By.xpath("//yt-formatted-string[text() = 'View count']")).click();
        adds.get(0).click();
























































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
