package org.oorsprong.webservices.stepdefinitions.soap.countryinfoservice.countryname;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.oorsprong.webservices.stepdefinitions.soap.countryinfoservice.SetUp;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.containsString;
import static org.oorsprong.webservices.questions.ReturnStringValue.systemValue;
import static org.oorsprong.webservices.tasks.countryinfoservice.DoPost.doPost;
import static org.oorsprong.webservices.util.FileUtilities.readFile;

public class CountryNameWithCucumberStepDefinition extends SetUp {
    private static final String ADD_XML = System.getProperty("user.dir") + "\\src\\test\\resources\\countryinfoservice.countryname\\countryname.xml";
    private static final String ISOCODE = "[ISOCODE]";
    @Given("El usuario ha definido como código ISO {string}")
    public void elUsuarioHaDefinidoComoCódigoISO(String ISOCODE) {
        setUp();
        bodyRequest = defineBodyRequest(ISOCODE);
    }
    @When("El usuario ejecuta la solicitud")
    public void elUsuarioEjecutaLaSolicitud() {
        actor.attemptsTo(
                doPost().
                        usingThe(RESOURCE).
                        with(headers()).
                        and(bodyRequest)
        );
    }

    @Then("El usuario debería obtener {string}.")
    public void elUsuarioDeberíaObtener(String pais) {
        actor.should(
                seeThatResponse(
                        "El código de respuesta HTTP debe ser: " + SC_OK,
                        response -> response
                                .statusCode(SC_OK)
                ),
                seeThat(
                        "El resultado de la petición debe ser: ",
                        systemValue(fromLastResponseBy(actor)),
                        containsString("<m:CountryNameResult>"+pais+"</m:CountryNameResult>")
                )
        );
    }


    private String defineBodyRequest(String ISOCODE){
        return readFile(ADD_XML)
                .replace(this.ISOCODE, ISOCODE);
    }


}
