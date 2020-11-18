package google.com.trends.step_definitions;

import google.com.trends.utilities.ConfigurationReader;
import google.com.trends.utilities.Driver;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    private final static Logger logger=Logger.getLogger(Hooks.class);

    @Before
    public void setup(){
        logger.info("::: Starting Automation");
        logger.info("Browser type: "+ ConfigurationReader.getProperty("browser"));
        logger.info("URL: "+ ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();

    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            logger.info("Taking a screenshot");
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
        logger.info("::: Ending automation :::");
    }
}
