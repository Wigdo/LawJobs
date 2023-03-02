package Wigdo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;


public class AllensJobList {

    private WebDriver driver;
    private List<WebElement> list;

    public AllensJobList ()

    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        initiateDriver();
        getTitle();
        setJobElements();
        getJobElements();
        quitDriver();
    }

    public void initiateDriver ()
    {
        //ChromeOptions options = new ChromeOptions();
        //   options.setHeadless(true); make sure you pass options as an argument thus ChromeDriver(options)
        // I can turn this class into a general use object !
        driver.get("https://fsr.cvmailuk.com/nortonrosefulbright/main.cfm?srxksl=1");
    }

    public List<WebElement> setJobElements ()

    {
        list = driver.findElements(By.className("jobMoreDetailCaptionStyle"));
        return list;
    }

    public void getJobElements ()
    {
        System.out.println(list.get(1).getText());
    }

    public void getTitle()
    {
        String title = driver.getTitle();
        System.out.println(title);
    }

    public void quitDriver ()
    {
        driver.quit();
    }


}
