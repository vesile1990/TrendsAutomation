package google.com.trends.pages;

import google.com.trends.utilities.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {
    //Abstract class in Java is similar to interface except that it can contain default method implementation.
    // An abstract class can have an abstract method without body and it can have methods with implementation also.
    //
    //abstract keyword is used to create a abstract class and method.
    // Abstract class in java can’t be instantiated.
    // An abstract class is mostly used to provide a base for subclasses to extend and implement the
         // abstract methods and override or use the implemented methods in abstract class.

    private  final static Logger logger=Logger.getLogger(BasePage.class);
    protected WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    /**
     * Method used for navigation. Module name will be specified in feature file:
     *   And user navigates to "Activity Stream"
     *               ||
     *  |@Given("user navigates to {string}")
     *  public void user_navigates_to(String module){
     *      loginPage.navigateTo(module);
     *  }
     *              ||
     *
     * @param moduleName like Tasks, Mail, Calendar, Activity Stream
     */
    public void navigateTo(String moduleName){
        //if moduleName = Activity Stream, then xpath looks like this:
        // //span[contains(text(),'Activity Stream') and @class='menu-item-link-text']
        //  and this xpath represents Activity Stream kink on the page
        String xpath = "//span[contains(text(),'"+moduleName+"') and @class='menu-item-link-text']";
        //wait for presence of element and click on it
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
        logger.info("Navigating to: "+moduleName);
    }
}


