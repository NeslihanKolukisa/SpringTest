package tr.com.example.user.service.impl;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    @Test
    @DisplayName("Json Path Test")
    public void jsonPathTest(){
        String jsonStr = "[{\"name\":\"Test1\",\"password\":\"test1\"},{\"name\":\"Test2\",\"password\":\"test2\"}]";
        DocumentContext context = JsonPath.parse(jsonStr);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(2);
        List<String> names = context.read("$..name");
        System.out.println(names.toString());
        String first = context.read("$.[1]").toString();
        System.out.println(first);
    }
}
