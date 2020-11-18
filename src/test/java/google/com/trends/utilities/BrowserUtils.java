package google.com.trends.utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
        public static void waitForLoaderMask() {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 25);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class*='loader-mask']")));
        }

        public static void waitFor(int seconds){
            try {
                Thread.sleep(seconds*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

