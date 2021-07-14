package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\User\\Desktop\\eclipse\\JanDecCucumberSession\\src\\main\\java\\features",
				 glue = "step_definitions",
				 monochrome = true,
				 plugin = {"pretty", "html:target/html/index.html", "json:target/json/testExecution"},
				 tags = "@DataDriven"
					)

public class Runner {
	// Runner class concept -> Junit
}
