package ch.puzzle.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person") // "user" table is not allowed in PostgreSQL
public class User {
    private @Id @GeneratedValue Long id;
    @NotBlank
    @Size(min = 2, max = 20)
    private String firstname;
    @NotBlank
    @Size(min = 2, max = 20)
    private String lastname;
    @NotBlank
    private String email;
    @NotNull
    @Size(min = 0, max = 150)
    private Integer age;

    public User() {
    }

    public User(Long id, String firstname, String lastname, String email, Integer age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && firstname.equals(user.firstname) && lastname.equals(user.lastname) && email.equals(user.email) && age.equals(user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, email, age);
    }
}
