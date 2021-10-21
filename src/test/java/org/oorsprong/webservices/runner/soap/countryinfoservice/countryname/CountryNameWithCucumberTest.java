package org.oorsprong.webservices.runner.soap.countryinfoservice.countryname;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src\\test\\resources\\features.countryinfoservice.countryname\\CountryName.feature"},
        glue = {"org\\oorsprong\\webservices\\stepdefinitions\\soap\\countryinfoservice\\countryname"}
)

public class CountryNameWithCucumberTest {
}
