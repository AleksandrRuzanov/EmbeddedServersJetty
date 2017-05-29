package com.epam.embeddedservers.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr_Ruzanov on 25.05.2017.
 */
@Entity
@Table(name = "department")
public class Department extends AbstractEntity {

    @OneToMany(mappedBy = "department")
    private List<Person> personList;

    public Department() {
    }

    public List<Person> getPersonList() {
        if (personList == null)
            personList = new ArrayList<Person>();
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                '}';
    }
}
