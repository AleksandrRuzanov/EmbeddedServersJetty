package com.epam.embeddedservers.service;

import com.epam.embeddedservers.config.HibernateSessionFactory;
import com.epam.embeddedservers.entity.AbstractEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Aleksandr_Ruzanov on 23.05.2017.
 */

public class EntityService<T extends AbstractEntity> {

    private Class clazz;

    public EntityService(Class clazz) {
        this.clazz = clazz;
    }

    public T add(T t) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Serializable id = session.save(t);
            session.flush();
            t = (T) session.get(clazz, id);
        } finally {
            session.close();

        }
        return t;
    }

    public void delete(Long id) {
        T t = getById(id);
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(t);
            session.getTransaction().commit();
        } finally {
            session.close();
        }

    }

    public T getById(Long id) {
        T t = null;
        if (id != null) {
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            try {
                session.beginTransaction();
                t = (T) session.get(clazz, id);
            } finally {
                session.close();
            }
        }
        return t;

    }

    public T update(T t) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return t;
    }

    public List<T> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<T> list;
        try {
            session.beginTransaction();
            list = (List<T>) session.createNativeQuery("SELECT * FROM " + clazz.getSimpleName()).addEntity(clazz).list();
        } finally {
            session.close();
        }
        return list;
    }
}
