package com.epam.embeddedservers.service;

import com.epam.embeddedservers.config.HibernateSessionFactory;
import com.epam.embeddedservers.entity.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Aleksandr_Ruzanov on 26.05.2017.
 */
public class PersonService extends EntityService<Person> {

    public PersonService() {
        super(Person.class);
    }

    public List<Person> getAllDep(Long depid) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Person> list;
        try {
            session.beginTransaction();
            list = (List<Person>) session.createNativeQuery("SELECT * FROM Person where department_id=" + depid).addEntity(Person.class).list();
        } finally {
            session.close();
        }
        return list;
    }
}
