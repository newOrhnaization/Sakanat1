package com.example.SW_finalTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "case", monochrome= true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue= {"com.example.SW_finalTest"})
public class acceptanceTest {

}
