package Wigdo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Iterator;

public class AllensJobList {

    private WebDriver driver;
    private List<WebElement> jobList;
    private List<WebElement> locationList;

    public AllensJobList ()

    {
        ChromeOptions optionsTwo = new ChromeOptions();
        optionsTwo.addArguments("--remote-allow-origins=*").setHeadless(true);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(optionsTwo);

        initiateDriver();
        getTitle();
        setJobElements();
        getJobElements();
        //setLocation();
        //getLocation();
        quitDriver();
    }

    public void initiateDriver ()
    {
            driver.get("https://fsr.cvmailuk.com/nortonrosefulbright/main.cfm?srxksl=1");

 }

    public List<WebElement> setJobElements ()

    {
        jobList = driver.findElements(By.className("jobMoreDetailCaptionStyle"));
        return jobList;
    }

    public List<WebElement> setLocation ()
    {
        locationList = driver.findElements((By.className("jbTableTextStyle")));
        return locationList;
    }

    public void getLocation ()
    {
        for (int i = 0; i < locationList.size(); i++) {
            System.out.println(locationList.get(i).getText());
        }
    }

    public void getJobElements ()
    {
        for (int i = 0; i < jobList.size(); i++) {
            System.out.println(jobList.get(i).getText());
        }
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
