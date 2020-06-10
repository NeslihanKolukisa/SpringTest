package tr.com.example.user.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import tr.com.example.user.dao.UsersRepository;
import tr.com.example.user.document.UserDocument;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IMongoTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    @Qualifier("usersRepository")
    private UsersRepository usersRepository;

    @Test
    public void testSaveUser() {
        assertNotNull(mongoTemplate);
        UserDocument userDocument = new UserDocument("Nesli","123");
        mongoTemplate.save(userDocument);
    }

    @Test
    public void testFindByName() {
        List<UserDocument> userDocuments = Arrays.asList(
                new UserDocument("Neslihan", "12345"));

        for (UserDocument userDocument : userDocuments)
            mongoTemplate.save(userDocument);

        List<UserDocument> matches = usersRepository.findByName("Neslihan");
        assertEquals(2, matches.size());
    }

}
