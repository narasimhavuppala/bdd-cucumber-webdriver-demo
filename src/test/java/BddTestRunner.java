import com.bdd.util.WebElementUtil;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        tags = {"@HL"})
public class BddTestRunner {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://todomvc4tasj.herokuapp.com/#/");
        List<WebElement> wel = driver.findElements(By.tagName("input"));
        System.out.println(wel);
        WebElement element = wel.get(0);
        element.sendKeys("hello");
        element.sendKeys(Keys.ENTER);
        element.click();
        //label[text()='test']/following-sibling::button

        wel = driver.findElements(By.xpath("//label[text()='test']/following-sibling::button"));
        System.out.println(wel);
        element = wel.get(0);
        element.click();

    }

    private static int ways(int total, int k) {
        int[][] t = new int[k + 1][total + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= total; j++) {
                if (j < i) t[i][j] = t[i - 1][j];
                else if (i == j) t[i][j] = 1 + t[i - 1][j];
                else t[i][j] = t[i - 1][j] + t[i][j - i];
            }
        }
        return t[k][total];
    }

}
