package com.epam.embeddedservers.factory;

import com.epam.embeddedservers.entity.Department;
import com.epam.embeddedservers.entity.Person;
import com.epam.embeddedservers.service.EntityService;
import com.epam.embeddedservers.service.PersonService;

/**
 * Created by Aleksandr_Ruzanov on 26.05.2017.
 */
public class FactoryService {

    private static final PersonService personEntityService = new PersonService();
    private static EntityService<Department> departmentEntityService = new EntityService<Department>(Department.class);


    public static EntityService getService(Class clazz) {
        EntityService entityService = null;
        if (clazz == Person.class)
            entityService = personEntityService;
        else if (clazz == Department.class)
            entityService = departmentEntityService;
        return entityService;
    }
}
