package tr.com.example.user.service.impl;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TestWithSpring {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void loads() throws JSONException {
        String response = testRestTemplate.getForObject("/auth/getDummyUser", String.class);
        JSONAssert.assertEquals("{\"name\":\"Dummy\",\"password\":\"dummy\"}", response, false);
    }
}
