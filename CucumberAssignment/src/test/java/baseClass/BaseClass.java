package baseClass;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;
import cucumber.api.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	// RequestSpecification used for adding header, parameters and body
	static protected RequestSpecification requestSpec = null;
	static protected Response response = null;
	static protected Scenario scenario = null;

	// Load values of properties file using ResourceBundle
	protected ResourceBundle bundle = ResourceBundle.getBundle("config");

	public RequestSpecification getURI(String baseURI) {
		return given().baseUri(baseURI);
	}

}
