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

        setMelbourne();
        getJobs();
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

    public List<WebElement> setMelbourne ()
    {
        WebElement location = driver.findElement(By.xpath("//*[@id=\"groupType_8\"]/option[24]"));
        location.click();

        WebElement search = driver.findElement(By.className("jbFilterButtonStyleSpecial"));
        search.click();

        System.out.println(driver.getCurrentUrl());

        jobList = driver.findElements(By.className("jobMoreDetailCaptionStyle"));
        return jobList;

    }

    public void getJobs ()
    {
            for (int i = 0; i < jobList.size(); i++) {

                    System.out.println(jobList.get(i).getText());
            }
    }

    public void getLocation ()
    {
        for (int i = 0; i < locationList.size(); i++)
        {
                if (locationList.get(i).getText().equals("Melbourne"));
            {
                System.out.println(locationList.get(i).getText());
            }
        }
    }

    public void getJobElements ()
    {
        for (int i = 0; i < jobList.size(); i++) {

            if (jobList.get(i).getText().contains("Associate")) {

                System.out.println(jobList.get(i).getText());
            }
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
