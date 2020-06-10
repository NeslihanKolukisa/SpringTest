package tr.com.example.user.document;

import org.springframework.data.mongodb.core.mapping.Document;
import tr.com.example.user.document.base.AbstractDocument;

import javax.persistence.Entity;

@Entity
@Document(collection = "users")
public class UserDocument extends AbstractDocument {
    private String name;
    private String password;

    public UserDocument(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserDocument() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
