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
    private List<WebElement> list;

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
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
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
