package com.vaadin.vaadin_spring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "patients")
@NoArgsConstructor
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String patronymic;
    String telephone;

    public Patient(String name, String surname, String patronymic, String telephone) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.telephone = telephone;
    }
}
