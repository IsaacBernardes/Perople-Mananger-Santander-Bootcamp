package com.bootcamp.peoplemanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Date birthDate;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String cpf;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Phone> phones;

    public String toString() {
        StringBuilder personToString = new StringBuilder()
                .append("Id: ").append(this.id).append("\t|\t")
                .append("Nome: ").append(this.name).append("\t|\t")
                .append("Aniversário: ").append(this.birthDate).append("\t|\t")
                .append("Endereço: ").append(this.address).append("\t|\t");

        return personToString.toString();
    }
}
