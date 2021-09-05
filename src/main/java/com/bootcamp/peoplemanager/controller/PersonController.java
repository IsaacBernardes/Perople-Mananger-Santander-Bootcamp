package com.bootcamp.peoplemanager.controller;

import com.bootcamp.peoplemanager.dto.ApiResponse;
import com.bootcamp.peoplemanager.model.Person;
import com.bootcamp.peoplemanager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public ApiResponse getPeople() {

        ApiResponse response = new ApiResponse();

        try {
            List<Person> userList = personService.findAll();
            response.setMessage("Ação executada com sucesso").setResult(userList);
        } catch (Exception e) {
            response.setMessage(e.getMessage()).setResult(null).setError(true);
        }

        return response;
    }

    @GetMapping("/{id}")
    public ApiResponse getPerson(@PathVariable Long id) {

        System.out.println(id);

        ApiResponse response = new ApiResponse();

        try {
            Optional<Person> person = personService.findOne(id);
            response.setMessage("Ação executada com sucesso!").setResult(person);
        } catch (Exception e) {
            response.setMessage(e.getMessage()).setResult(null).setError(true);
        }

        return response;
    }

    @PostMapping(consumes = "application/json")
    public ApiResponse insertPerson(@RequestBody Person person) {

        ApiResponse response = new ApiResponse();

        try {
            person.setId(null);
            Person newPerson = personService.save(person);
            response.setMessage("Ação executada com sucesso!").setResult(newPerson);
        } catch (Exception e) {
            response.setMessage(e.getMessage()).setResult(null).setError(true);
        }

        return response;
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ApiResponse updatePerson(@PathVariable Long id, @RequestBody Person person) {

        ApiResponse response = new ApiResponse();

        try {
            person.setId(id);
            Person updatedPerson = personService.save(person);
            response.setMessage("Ação executada com sucesso!").setResult(updatedPerson);
        } catch (Exception e) {
            response.setMessage(e.getMessage()).setResult(null).setError(true);
        }

        return response;
    }

    @DeleteMapping(value = "/{id}")
    public ApiResponse updatePerson(@PathVariable Long id) {

        ApiResponse response = new ApiResponse();

        try {
            int deletedPerson = personService.delete(id);
            if (deletedPerson >= 1) {
                response.setMessage("Ação executada com sucesso!").setResult(null);
            } else {
                response.setMessage("Nenhum usuário com esse id foi encontrado!").setResult(null).setError(true);
            }
        } catch (Exception e) {
            response.setMessage(e.getMessage()).setResult(null).setError(true);
        }

        return response;
    }




}
