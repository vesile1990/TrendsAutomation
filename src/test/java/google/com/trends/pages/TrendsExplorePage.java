package google.com.trends.pages;

import google.com.trends.utilities.ConfigurationReader;
import google.com.trends.utilities.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;

public class TrendsExplorePage extends BasePage{

    private final static Logger logger=Logger.getLogger(TrendsExplorePage.class);
    JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();


    @FindBy(xpath = "//h2[@class='header-sub-title']/span")
    private WebElement pageName;
    @FindBy(xpath = "//button[@class='compare-term-container add-term-button pill-outline md-button md-ink-ripple']")
    private WebElement compareButton;
    @FindBy(xpath = "(//input[contains(@id,'input-')])[2]")
    private WebElement compareButton2;

    public void getPageName(){
        wait.until(ExpectedConditions.visibilityOf(pageName));
    }
    public void compareItem(String word){
        logger.info("Word: "+ ConfigurationReader.getProperty("compareWord"));
        wait.until(ExpectedConditions.visibilityOf(compareButton)).click();
        wait.until(ExpectedConditions.visibilityOf(compareButton2)).sendKeys(word);
        wait.until(ExpectedConditions.visibilityOf(compareButton2)).sendKeys(Keys.ARROW_DOWN);
        wait.until(ExpectedConditions.visibilityOf(compareButton2)).sendKeys(Keys.ENTER);

    }


}
