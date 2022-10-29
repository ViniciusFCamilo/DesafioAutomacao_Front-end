package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/reports/RunDesafioTest.html",
        features = "src/test/resources/features",
        tags = "@teste",
        glue = {"steps"}
)
public class RunDesafioTest{
    public static WebDriver driver;
    public static void start(){
        driver = new ChromeDriver();
    }
}
