package com.vaadin.vaadin_spring.repository;

import com.vaadin.vaadin_spring.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
