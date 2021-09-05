package com.bootcamp.peoplemanager.service;

import com.bootcamp.peoplemanager.model.Person;
import com.bootcamp.peoplemanager.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        return (List) repository.findAll();
    }

    public Optional<Person> findOne(Long id) {
        return repository.findById(id);
    }

    public Person save(Person person) {
        return repository.save(person);
    }

    public void delete(Person person) {
        repository.delete(person);
    }

    public int delete(Long id) {
        return repository.delete(id);
    }
}
