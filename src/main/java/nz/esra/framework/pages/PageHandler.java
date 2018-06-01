package nz.esra.framework.pages;

import nz.esra.framework.config.ConfigurationLoader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

/**
 * Class to implement the web driver. It should be a framework class that will use selenium webdriver so the
 * framework implementation does not care about the internal libraries used or dependencies on version
 */
public class PageHandler {
    private WebDriver driver;
    protected ConfigurationLoader loader = ConfigurationLoader.getInstance();

    public PageHandler(){
        driver= buildDriver();
    }

    //TODO: design a proper exception handler mechanism for configuration errors
    private WebDriver buildDriver(){
        //user Browser config and build drivers accordingly
        if ("chrome".equalsIgnoreCase(loader.getConfig().getBrowserConfig().getType())){
            System.setProperty("webdriver.chrome.driver", loader.getConfig().getBrowserConfig().getDriverPath());
            ChromeOptions options = new ChromeOptions();
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(loader.getConfig().getBrowserConfig().getWidth(),loader.getConfig().getBrowserConfig().getHeight()));
            return driver;
        }
        return null;
    }

    public String captureScreenShot() throws IOException {
        String filePath = loader.getConfig().getFrameworkConfig().getReports().getScreenShotPath();
        String fileName = filePath+System.currentTimeMillis()+".png";
        driver.manage().window().maximize();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(fileName));
        driver.close();
        return fileName;
    }


    public void click(By element){
        driver.findElement(element).click();
    }

    public void gotoUrl(String url){
        driver.get(url);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public void closeWindow(){
        driver.close();
    }

}
