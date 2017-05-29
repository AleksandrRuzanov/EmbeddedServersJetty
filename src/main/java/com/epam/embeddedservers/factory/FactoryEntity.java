package com.epam.embeddedservers.factory;

import com.epam.embeddedservers.entity.AbstractEntity;
import com.epam.embeddedservers.entity.Department;
import com.epam.embeddedservers.entity.Person;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Aleksandr_Ruzanov on 25.05.2017.
 */
public class FactoryEntity {

    public static AbstractEntity getEntityByRequest(Class clazz, HttpServletRequest request) {
        if (clazz == Person.class) {
            Long id = request.getParameter("id") == null ? null : Long.parseLong(request.getParameter("id"));
            Long depid = request.getParameter("depid") == null ? null : Long.parseLong(request.getParameter("depid"));
            Person person = (Person) FactoryService.getService(Person.class).getById(id);
            if (person == null) {
                person = new Person();
            }
            person.setEmail(request.getParameter("email"));
            person.setName(request.getParameter("name"));
            person.setDepartment((Department) FactoryService.getService(Department.class).getById(depid));
            person.setAge(request.getParameter("age") == null ? null : Integer.parseInt(request.getParameter("age")));
            return person;
        } else if (clazz == Department.class) {
            Long id = request.getParameter("id") == null ? null : Long.parseLong(request.getParameter("id"));
            Department department = (Department) FactoryService.getService(Department.class).getById(id);
            if (department == null)
                department = new Department();
            department.setName(request.getParameter("name"));
            return department;
        }
        return null;
    }
}
