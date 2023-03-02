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
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        initiateDriver();
        getTitle();
        setJobElements();
        getJobElements();
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

        return locationList;
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
