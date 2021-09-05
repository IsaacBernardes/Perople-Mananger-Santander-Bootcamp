package com.bootcamp.peoplemanager.repository;

import com.bootcamp.peoplemanager.model.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    @Modifying
    @Query("DELETE FROM Person p WHERE p.id = :id")
    public int delete(@Param("id") Long id);

}
