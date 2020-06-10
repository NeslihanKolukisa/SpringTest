package tr.com.example.user.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestMockMVC {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void mockBasic() throws Exception {
        RequestBuilder builder =
                MockMvcRequestBuilders.get("/auth/say-hi").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().string("Merhaba"))
                .andReturn();
    }

    @Test
    public void dummyBasic() throws Exception {
        RequestBuilder builder =
                MockMvcRequestBuilders.get("/auth/getDummyUser").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"name\":\"Dummy\",\"password\":\"dummy\"}"))
                .andReturn();
    }

    @Test
    @DisplayName("Json Assert")
    public void jsonAssertTest() throws Exception {
        RequestBuilder builder =
                MockMvcRequestBuilders.get("/auth/getDummyUser").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"name\":\"Dummy\",\"password\":\"dummy\"}"))
                .andReturn();
        JSONAssert.assertEquals("{\"name\":\"Dummy\",\"password\":\"dummy\"}" , result.getResponse().getContentAsString(), true);
        JSONAssert.assertEquals("{\"name\":\"Dummy\"}" , result.getResponse().getContentAsString(), false);
        JSONAssert.assertEquals("{name:Dummy}" , result.getResponse().getContentAsString(), false);

    }
}
