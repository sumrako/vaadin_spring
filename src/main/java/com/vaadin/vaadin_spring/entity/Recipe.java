package com.vaadin.vaadin_spring.entity;

import com.vaadin.vaadin_spring.auxiliary.priority.Priority;
import com.vaadin.vaadin_spring.auxiliary.priority.PriorityConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "recipes")
@NoArgsConstructor
public class Recipe {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    String description;

    @OneToOne
    @JoinColumn(name = "patient")
    Patient patient;

    @OneToOne
    @JoinColumn(name = "doctor")
    Doctor doctor;

    @Column(name = "date_of_creation")
    Date dateOfCreation;

    @Column(name = "validity_period")
    Date validityPeriod;

    @Convert(converter = PriorityConverter.class)
    Priority priority;

    public Recipe(String description, Patient patient, Doctor doctor, Date dateOfCreation, Date validityPeriod, Priority priority) {
        this.description = description;
        this.patient = patient;
        this.doctor = doctor;
        this.dateOfCreation = dateOfCreation;
        this.validityPeriod = validityPeriod;
        this.priority = priority;
    }
}
