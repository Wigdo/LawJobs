package Wigdo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class AllensJobList {

    private WebDriver driver;
    private List<WebElement> jobList;
    private List<WebElement> locationList;

    private List<WebElement> urlList;
    private int counter;
    private int i;

    public AllensJobList ()

    {
        ChromeOptions optionsTwo = new ChromeOptions();
        optionsTwo.addArguments("--remote-allow-origins=*").setHeadless(true);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(optionsTwo);

        initiateDriver();
        getTitle();
        setMelbourneJobs();
        getJobs();
        setURLs();
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

    public List<WebElement> setMelbourneJobs ()
    {
        WebElement location = driver.findElement(By.xpath("//*[@id=\"groupType_8\"]/option[24]"));
        location.click();

        WebElement search = driver.findElement(By.className("jbFilterButtonStyleSpecial"));
        search.click();

        System.out.println(driver.getCurrentUrl());

        jobList = driver.findElements(By.className("jobMoreDetailCaptionStyle"));
        return jobList;
    }

    public int getJobs ()
    {
          counter = 0;

            for (int i = 0; i < jobList.size(); i++) {

                    System.out.println(jobList.get(i).getText());
                    counter ++;
            }
            System.out.println(counter);

            return counter;
    }

    public ArrayList<String> setURLs ()
    {
        i = 2;

        ArrayList <String> rlList = new ArrayList<>();

        for (int x = 0; x < counter; x++) {

            if (i <= counter + 1)
            {
                i++;
            }
            String row = Integer.toString(i-1);
            rlList.add(driver.findElement(By.xpath("//*[@id=\"jobBoard\"]/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[" + row + "]/td[2]/a")).getAttribute("href"));
        }

        for (int x = 0; x < rlList.size(); x++)
        {
            System.out.println(rlList.get(x));
        }

        return rlList;
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
