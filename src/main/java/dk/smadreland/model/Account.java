package dk.smadreland.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "account",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    /*
     *SMART
     * We can, through JPA, write a query here
     * and execute it every time the property below is called.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // join account and account_roles
    @JoinTable(
            name = "accounts__account_roles",
            joinColumns = @JoinColumn(
                    name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "account_role_id", referencedColumnName = "id"))
    private Collection< AccountRole > roles;
    /* /SMART */

    public Account() {}

    public Account(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Account(String firstName, String lastName, String email, String password, Collection < AccountRole > roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection < AccountRole > getRoles() {
        return roles;
    }

    public void setRoles(Collection < AccountRole > roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + "**********" + '\'' +
                ", roles=" + roles +
                '}';
    }
}
