package tr.com.example.user.dao.custom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import tr.com.example.user.document.UserDocument;

import java.util.List;

@Component("customUserRepositoryImpl")
@CacheConfig(cacheNames = "customUserRepository")
public class CustomUsersRepositoryImpl implements CustomUsersRepository {
    private static final Logger logger = LogManager.getLogger(CustomUsersRepositoryImpl.class);
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    @Cacheable(key = "{#p0, #p1}")
    public boolean controlUser(String name, String password) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        query.addCriteria(Criteria.where("password").is(password));
        List<UserDocument> userDocuments = mongoTemplate.find(query, UserDocument.class);
        if(userDocuments.size() == 0)
            return false;
        else{
            logger.error("Too Many User " + name);
            return true;
        }
    }
}
