package com.vaadin.vaadin_spring.service;

import com.vaadin.vaadin_spring.entity.Doctor;
import com.vaadin.vaadin_spring.entity.Patient;
import com.vaadin.vaadin_spring.entity.Recipe;

import java.util.List;
import java.util.Optional;

public interface HospitalService {
    List<Doctor> getAllDoctors();
    void saveDoctor(Doctor doctor);
    Optional<Doctor> findDoctor(Long id);
    void deleteDoctor(Doctor doctor);

    List<Recipe> getAllRecipes();
    void saveRecipe(Recipe recipe);
    Recipe getRecipe(Long id);
    void deleteRecipe(Long id);
    void deleteRecipe(Recipe recipe);

    List<Patient> getAllPatients();
    void savePatient(Patient patient);
    Patient getPatient(Long id);
    void deletePatient(Long id);
    void deletePatient(Patient patient);
}
