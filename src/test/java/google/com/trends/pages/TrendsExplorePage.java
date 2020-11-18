package google.com.trends.pages;

import google.com.trends.utilities.ConfigurationReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;

public class TrendsExplorePage extends BasePage{

    private final static Logger logger=Logger.getLogger(TrendsExplorePage.class);

    @FindBy(xpath = "//h2[@class='header-sub-title']/span")
    private WebElement pageName;
    @FindBy(xpath = "//button[@class='compare-term-container add-term-button pill-outline md-button md-ink-ripple']")
    private WebElement compareButton;
    @FindBy(id = "input-124")
    private WebElement compareButton2;

    public void validPageName(String word){
        logger.info("Word: "+ ConfigurationReader.getProperty("compareWord"));
        wait.until(ExpectedConditions.visibilityOf(pageName));

    }
    public void compareItem(String word){
        logger.info("Word: "+ ConfigurationReader.getProperty("compareWord"));
        wait.until(ExpectedConditions.visibilityOf(compareButton)).click();
        compareButton2.sendKeys(word, Keys.ENTER);
    }

}
