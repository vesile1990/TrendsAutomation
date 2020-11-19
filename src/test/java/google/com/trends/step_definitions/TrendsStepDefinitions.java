package google.com.trends.step_definitions;

import google.com.trends.pages.TrendsComparePage;
import google.com.trends.pages.TrendsExplorePage;
import google.com.trends.pages.TrendsMainPage;
import google.com.trends.utilities.ConfigurationReader;
import google.com.trends.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class TrendsStepDefinitions {
    private final static Logger logger=Logger.getLogger(TrendsStepDefinitions.class);
    public TrendsMainPage trendsMainPage=new TrendsMainPage();
    public TrendsExplorePage trendsExplorePage=new TrendsExplorePage();
    public TrendsComparePage trendsComparePage=new TrendsComparePage();

    @Given("user is on the main page")
    public void userIsOnTheMAinPage() {
        String URL= ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
    }

    @When("user enter {string} on search box")
    public void userEnterOnSearchBox(String arg0) {
        trendsMainPage.searchItem(ConfigurationReader.getProperty("firstWord"));
    }

    @Then("user navigates to explore page")
    public void userNavigatesToExplorePage() {
        logger.info("Verify that title contains Explore");
        trendsExplorePage.getPageName();
        Assert.assertTrue( Driver.getDriver().getTitle().contains("Explore"));

    }

    @And("user enter {string} to the +Compare field")
    public void userEnterToTheCompareField(String arg0) {
        trendsExplorePage.compareItem(ConfigurationReader.getProperty("compareWord"));
    }

    @Then("user should be on compare page")
    public void userNavigatesToComparePage() {
        logger.info("Verify page is Compare");
        trendsComparePage.getPageName();
        Assert.assertTrue( trendsComparePage.toString().contains("Compare"));

    }

    @And("user select filters")
    public void userSelectFilters() {
        trendsComparePage.selectLocation(ConfigurationReader.getProperty("location"));
        trendsComparePage.selectTime();
    }

    @And("user select compare by metro")
    public void userSelectCompareByMetro() {
    }

    @Then("user verify percentual ratio")
    public void userVerifyPercentualRatio() {
    }
}
