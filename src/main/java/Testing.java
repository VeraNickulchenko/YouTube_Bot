import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Testing {
    public WebDriver driver;
   public  WebElement account;
   public  String first_name = "Maven23";
    public String last_name = "Java12";
   public  String email = "Javadark334@gmail.com";
   public  String phone_number = "09909443333344412";
    public String passmord = "password332";




    @BeforeClass
    void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority=1)
    void pageLoaded(){
        driver.get("https://demo.opencart.com/index.php?route=common/home");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement title = driver.findElement(By.xpath("//h1/a[text()='Your Store']"));
        boolean actual = title.isDisplayed();
        Assert.assertTrue(actual, "Title is not displayed");
    }

@Test(priority = 2)
    void searchisworking(){
        WebElement search = driver.findElement(By.xpath("//input[@class='form-control input-lg']"));
        search.sendKeys("macbook");
        search.sendKeys(Keys.ENTER);
        int i =0;
        boolean actual;
        List<WebElement> adds = driver.findElements(By.xpath("//div[@class='product-thumb']"));
        for (WebElement e:adds) {
           if(e.getText().contains("MacBook")){
                i++;

            }
           else if(i==5){
               break;
           }
       }
        if(i==3){
            actual = true;
        }
        else{
             actual = false;
        }
        Assert.assertTrue(actual, "There is an error");

    }
@Test(priority = 3)
    void sort(){
        WebElement sort = driver.findElement(By.xpath("//select[@id ='input-sort']"));
        sort.click();
        WebElement option = driver.findElement(By.xpath("//select/option[text() = 'Price (High > Low)']"));
        option.click();
        List<WebElement> adds = driver.findElements(By.xpath("//div[@class='product-thumb']"));
        boolean actual1 = adds.get(0).getText().contains("Ex Tax: $2,000.00");
        boolean actual2 = adds.get(1).getText().contains("Ex Tax: $1,000.00");
        boolean actual3 = adds.get(2).getText().contains("Ex Tax: $500.00");
        Assert.assertTrue(actual1, "There is an error");
        Assert.assertTrue(actual2, "There is an error");
        Assert.assertTrue(actual3, "There is an error");




    }
@Test(priority = 4)
    void registration(){
        account = driver.findElement(By.xpath("//ul/li/a[@class = 'dropdown-toggle']"));
        account.click();
        WebElement register = driver.findElement(By.xpath("//ul/li/a[text() = 'Register']"));
        register.click();
        WebElement firstname = driver.findElement(By.xpath("//input[@id = 'input-firstname']"));
        firstname.sendKeys(first_name);
        driver.findElement(By.xpath("//input[@id = 'input-lastname']")).sendKeys(last_name);
        driver.findElement(By.xpath("//input[@id = 'input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id = 'input-telephone']")).sendKeys(phone_number);
        driver.findElement(By.xpath("//input[@id = 'input-password']")).sendKeys(passmord );
        driver.findElement(By.xpath("//input[@id = 'input-confirm']")).sendKeys(passmord );
        driver.findElement(By.xpath("//input[@name = 'agree']")).click();

        WebElement submit = driver.findElement(By.xpath("//input[@class ='btn btn-primary']"));
        submit.click();
       WebElement success = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
       boolean acrually = success.isDisplayed();
    Assert.assertTrue(acrually, "Registration was not succesful");







    }
    @Test(priority = 5)
    void login(){
        account = driver.findElement(By.xpath("//ul/li/a[@class = 'dropdown-toggle']"));
        account.click();
        driver.findElement(By.xpath("//li/a[text()='Logout']")).click();
        driver.findElement(By.xpath("//ul/li/a[@class = 'dropdown-toggle']")).click();
        driver.findElement(By.xpath("//li/a[text()='Login']")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(passmord);
        driver.findElement(By.xpath("//input[@class = 'btn btn-primary']")).click();
        WebElement succesful = driver.findElement(By.xpath("//h2[text()='My Account']"));
        boolean right = succesful.isDisplayed();
        Assert.assertTrue(right, "Something went wrong");



    }
@Test(priority = 6)
    void monitors(){
        driver.findElement(By.xpath("//h1/a[text()='Your Store']")).click();
        driver.findElement(By.xpath("//li/a[text()='Components']")).click();
        driver.findElement(By.xpath("//li/a[text()='Monitors (2)']")).click();
        boolean yes;
        List<WebElement> adds1 = driver.findElements(By.xpath("//div[@class='product-thumb']"));
        if(adds1.size() == 2){
            yes = true;
        }
        else {
             yes = false;
        }
        Assert.assertTrue(yes, "Something went wrong");
    }

    @AfterClass
    void postConditions(){
        driver.quit();
    }


 /*
  public WebDriver driver;
    WebElement cart;

    @Test(priority=1)
    void pageLoaded(){
        driver.get("https://demo.opencart.com/index.php?route=common/home");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement title = driver.findElement(By.xpath("//h1/a[text()='Your Store']"));
        boolean actual = title.isDisplayed();
        Assert.assertTrue(actual, "Title is not displayed");
    }
    @Test(priority=2)
    void cartIsEmpty(){
        cart = driver.findElement(By.xpath("//span[@id='cart-total']"));
        cart.click();
        WebElement text = driver.findElement(By.xpath("//p[@class='text-center']"));
//        boolean actual = text.getText().equals("Your shopping cart is empty!");
//        Assert.assertTrue(actual, "Cart is not empty");
        String cartText = text.getText();
        String expectedText = "Your shopping cart is empty!";
        Assert.assertEquals(cartText, expectedText, "Is not empty");
    }
    @Test(priority=3)
    void cartOneItem() throws InterruptedException {
        WebElement mac = driver.findElement(By.xpath("//img[@title='MacBook']"));
        mac.click();
        WebElement add = driver.findElement(By.xpath("//button[@id='button-cart']"));
        add.click();
        boolean actual = false;
        for(int i=0;i<10;i++){
            cart = driver.findElement(By.xpath("//span[@id='cart-total']"));
            actual = cart.getText().contains("1 item(s)");
            if(actual){break;}else {
                Thread.sleep(50);
            }
        }

        Assert.assertTrue(actual, "Cart does not contain 1 item");

    }

    @BeforeClass
    void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    //div[@class='product-thumb']

    @AfterClass
    void postConditions(){
        driver.quit();
    }
  */


}
