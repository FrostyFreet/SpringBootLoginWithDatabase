package com.website;

import jakarta.persistence.*;


@Table(name = "students")
@Entity
public class Students {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   @Column(name = "first_name")
    private String firstName;
   @Column(name = "last_name")
    private String lastName;
   @Column(name = "email")
    private String email;
   @Column(name = "gender")
    private String gender;
   @Column(name = "age")
    private Integer age;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

   public Students(){}

    public Students(Integer id, String firstName, String lastName, String email, String gender, Integer age,String username, String password) {
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;
       this.email = email;
       this.gender = gender;
       this.age = age;
       this.username = username;
       this.password = password;

    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {this.password = password;}
    public void setUsername(String username) {this.username = username;}

    public String getLastName() {
        return lastName;
    }
    public String getGender() {
        return gender;
    }
    public Integer getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
    public Integer getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getPassword() {return password;}
    public String getUsername() {return username;}
}
