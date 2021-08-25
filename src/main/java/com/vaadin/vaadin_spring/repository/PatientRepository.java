package com.vaadin.vaadin_spring.repository;

import com.vaadin.vaadin_spring.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
