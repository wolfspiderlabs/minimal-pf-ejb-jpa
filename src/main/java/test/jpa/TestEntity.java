package test.jpa;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "test")
public class TestEntity implements Serializable {
    private static final long serialVersionUID = -2408020196835981806L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="message")
    private String message;

    public TestEntity() {
    }

    public TestEntity(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
