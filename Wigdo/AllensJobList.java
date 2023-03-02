package Wigdo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;


public class AllensJobList {

    public AllensJobList ()

    {
        System.out.println("hello, you have instantiated the default constructor, congratulations!");
    }

    public void runTest ()

    {
        //ChromeOptions options = new ChromeOptions();
     //   options.setHeadless(true); make sure you pass options as an argument thus ChromeDriver(options)

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://fsr.cvmailuk.com/nortonrosefulbright/main.cfm?srxksl=1");

        String title = driver.getTitle();

        List<WebElement> list = driver.findElements(By.className("jobMoreDetailCaptionStyle"));




        WebElement webEl = driver.findElement(By.className("jobMoreDetailCaptionStyle"));
        webEl.click();

        driver.navigate().back();

        list.get(2).click();

        System.out.println(title);

        driver.quit();

    }



}
