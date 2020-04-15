package helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver newDriver() {
        InputStream in = BrowserFactory.class.getClassLoader().getResourceAsStream("gradle.properties");
        Properties props = new Properties();
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = props.getProperty("browser").toUpperCase();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        switch (name){
            case "CHROME": return new ChromeDriver(options);
            case "FIREFOX": return new FirefoxDriver();
            case "IE": return new InternetExplorerDriver();
            default: return new ChromeDriver(options);
        }
    }

    public static WebDriver getDriver(){
        WebDriver wd = newDriver();
        wd.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        return wd;
    }
}