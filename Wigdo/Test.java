package Wigdo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class Test {

    public Test ()
    {
        try {
            testGoogleSearch();
        }

        catch (Exception e)

        {
            System.out.println(e.getStackTrace());
        }

    }


        public void testGoogleSearch() throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", "/Users/ariwigdorowitz/Desktop/Java/ChromeDriver/chromedriver");

            ChromeOptions optionsTwo = new ChromeOptions();
            optionsTwo.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(optionsTwo);

            driver.get("http://www.google.com/");

            Thread.sleep(5000);  // Let the user actually see something!

            WebElement searchBox = driver.findElement(By.name("q"));

            searchBox.sendKeys("ChromeDriver");

            searchBox.submit();

            Thread.sleep(5000);  // Let the user actually see something!

            driver.quit();

        }

    }
