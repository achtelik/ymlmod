package it.achtelik.ymlmod;

import io.quarkus.test.junit.QuarkusTest;
import it.achtelik.ymlmod.testutils.FileUtils;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class YamlControllerTest {

    @Test
    public void testYmlEndpoint() throws Exception {
        String payload = new FileUtils().loadResourceAsString("yaml/test-template-01.yml");
        String result = new FileUtils().loadResourceAsString("yaml/test-template-01-result.yml");
        given().contentType(MediaType.TEXT_PLAIN)
                .body(payload)
                .post("/yml")
                .then()
                .statusCode(200)
                .body(is(result));
    }

}
