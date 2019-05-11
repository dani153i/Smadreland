package dk.smadreland.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "account_role")
public class AccountRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    public AccountRole() {}

    public AccountRole(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + title + '\'' +
                '}';
    }
}