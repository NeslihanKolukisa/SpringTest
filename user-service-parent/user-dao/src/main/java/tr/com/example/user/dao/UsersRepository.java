package tr.com.example.user.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tr.com.example.user.dao.custom.CustomUsersRepository;
import tr.com.example.user.document.UserDocument;

import java.util.List;

@Repository("usersRepository")
public interface UsersRepository extends MongoRepository<UserDocument, Long>, CustomUsersRepository {
    List<UserDocument> findByName(String name);
}
