package com.epam.embeddedservers.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Aleksandr_Ruzanov on 23.05.2017.
 */


@Entity
@Table(name = "person")
public class Person extends AbstractEntity {

    private String email;
    private Integer age;
    @ManyToOne
    private Department department;

    public Person() {
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

    public Department getDepartment() {
        if (department == null)
            department = new Department();
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", department=" + department +
                '}';
    }
}
