package Wigdo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

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
        System.out.println(driver.getPageSource());
        String title = driver.getTitle();

        System.out.println(title);

        driver.quit();

    }


}
