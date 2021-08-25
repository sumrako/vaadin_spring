package com.vaadin.vaadin_spring.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;
    String name;
    String surname;
    String patronymic;
    String specialization;
}
