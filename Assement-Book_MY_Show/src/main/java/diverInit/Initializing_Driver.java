package diverInit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Initializing_Driver {

    public static WebDriver ldriver;

    public WebDriver ini_driver() {
        WebDriver driver;


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\prana\\Desktop\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.setBinary("C:\\Users\\prana\\Desktop\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver(co);
        ldriver = driver;


        ldriver.manage().deleteAllCookies();
        ldriver.manage().window().maximize();
        return ldriver;


    }
}


