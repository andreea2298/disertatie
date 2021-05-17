package com.example.disertatie.domain;

public class User {
    public Integer cnp;
    public String firstname;
    public String lastname;
    public Integer age;

    public Integer getCnp() {
        return cnp;
    }

    public void setCnp(Integer cnp) {
        this.cnp = cnp;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
