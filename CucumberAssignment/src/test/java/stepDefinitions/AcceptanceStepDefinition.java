package stepDefinitions;

import baseClass.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.equalTo;

public class AcceptanceStepDefinition extends BaseClass {

	// ********hooks********

	@Before
	public void SetUp(Scenario s) {
		scenario = s;
	}

	@After
	public void CleanUp() {
		requestSpec = null;
		response = null;
	}

	// ***Given***

	@Given("RatesAPI for Foreign currency exchange rates is up and running")
	public void Rates_API_Foreign_currency_Exchange_rates() {

		// requestSpecification object to fetch base URI
		requestSpec = getURI(bundle.getString("uri"));

	}

	// ***When***

	@When("user hits the RatesAPI with endpoint as {string}")
	public void hit_the_RatesAPI(String endPoint) {
		scenario.write("Hitting API with endpoint to get response " + endPoint);
		// Getting response of the request using get method
		response = requestSpec.get(endPoint);
		scenario.write("Request of the response is " + response);

	}

	// ***Then***
	@Then("RatesAPI returns the success status code as {int}")
	public void RatesAPI_returns_Success_StatusCode(Integer expected) {
		// Validate the status code using assert
		response.then().assertThat().statusCode(expected);
		scenario.write("Response code received " + expected);
	}

	@Then("base value should be {string}")
	public void user_gets_the_correct_response_as_base_value(String stringResponse) {
		// Validate the response using assert
		response = requestSpec.get(stringResponse);
		scenario.write("Response received " + stringResponse);

	}

	@When("user hits the API with endpoint as {string}")
	public void user_hits_the_API_with_endpoint_as(String string) {
		scenario.write("Hitting RatesAPI with specific baseEndpoint and get response " + string);
		// Getting response through get method
		response = requestSpec.get(string);
		scenario.write("Request response received " + response);
	}

	@Then("API returns the status code as {int}")
	public void api_returns_the_status_code_as(Integer expectedValue) {
		// Validate the status code using assert
		response.then().assertThat().statusCode(expectedValue);
		scenario.write("Status code received " + expectedValue);
	}

	@And("error message is displayed as {string}")
	public void error_message_is_displayed_as(String expectedErrorMessage) {
		scenario.write("Verify error text message");
		// Verify error message using assert
		response.then().assertThat().body("error", equalTo(expectedErrorMessage));
		scenario.write("Reponse code received " + expectedErrorMessage);

	}

	@Then("Base value should be {string}")
	public void base_value_should_be(String baseValue) {
		scenario.write("Verify the base value");
		// Validate the base value
		response.then().assertThat().body("base", equalTo(baseValue));
		scenario.write("Base value received " + baseValue);
	}

}
