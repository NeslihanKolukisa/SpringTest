package tr.com.example.user.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatcher {

    @Test
    @DisplayName("Hamcrest Matcher")
    public void matcher(){
            List<Integer> integerList = Arrays.asList(1, 2, 3);
            assertThat(integerList, describedAs("Dizi boyutu 3 olmalıdır.", hasSize(3)));
            assertThat(integerList.get(2), anyOf(equalTo(1), equalTo(2), equalTo(3)));
            assertThat(integerList, hasItems(1));
            assertThat(integerList, everyItem(lessThan(5)));
            assertThat("", blankOrNullString());
            assertThat("ABCDE", startsWith("AB"));
    }
}
