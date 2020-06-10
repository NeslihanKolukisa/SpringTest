package tr.com.example.user.document.base;

import org.springframework.data.annotation.Id;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractDocument {
    @Id
    private String id;

    public AbstractDocument() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
