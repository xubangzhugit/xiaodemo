package com.thrift;

import com.thrift.frist.DataException;
import com.thrift.frist.Person;
import com.thrift.frist.PersonService;
import org.apache.thrift.TException;

public class example implements PersonService.Iface {

    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        Person p = new Person();
        p.setAge(19);
        p.setMarried(false);
        p.setUsername(username);
        return p;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println(person.getAge());
        System.out.println(person.getUsername());
        System.out.println(person.married);
    }
}
