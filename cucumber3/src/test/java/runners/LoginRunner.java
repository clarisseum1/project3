package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="src\\test\\java\\features\\2techfios.feature",
         glue= "steps",
          tags= " ",
          monochrome=true,
         // dryRun = false,
           plugin= {
        		   "pretty",
        		  
        		   "json:target/cucumber/report.json",
        		   "html:target/cucumber/report.html"
		}
                		 
                		  
           )
public class LoginRunner {
	
}
