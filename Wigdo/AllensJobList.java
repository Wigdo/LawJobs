package Wigdo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class AllensJobList {

    public AllensJobList ()

    {
        runTest();
    }

    public void runTest ()

    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://fsr.cvmailuk.com/nortonrosefulbright/main.cfm?srxksl=1");

        driver.quit();

    }


}
