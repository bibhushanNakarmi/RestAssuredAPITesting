package airlines;

import utils.jsonUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AirlineTests {
    @Test
    public void createAirline() throws IOException {

        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        Map<String, String> data = jsonUtils.getJsonDataAsMap(""+env+"/airlinesApiData.json");
        String endPoint = data.get("createAirlineEndpoint");
        Map<String, Object> payload = Payloads.getCreateAirlinePayloadFromMap("12222233333345",
                "ABC Airlines",
                "IN",
                "ABC",
                "ABC Slogan",
                "Mumbai",
                "abc.com",
                "1993");
        Response response = RestUtils.performPost(endPoint, payload, new HashMap<>());
        Assert.assertEquals(response.statusCode(),  200);
    }
}
