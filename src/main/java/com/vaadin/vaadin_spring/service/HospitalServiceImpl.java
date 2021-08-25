package com.vaadin.vaadin_spring.service;

import com.vaadin.vaadin_spring.entity.Doctor;
import com.vaadin.vaadin_spring.entity.Patient;
import com.vaadin.vaadin_spring.entity.Recipe;
import com.vaadin.vaadin_spring.repository.DoctorRepository;
import com.vaadin.vaadin_spring.repository.PatientRepository;
import com.vaadin.vaadin_spring.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public Optional<Doctor> findDoctor(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public void deleteDoctor(Doctor doctor) {
        doctorRepository.delete(doctor);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public Recipe getRecipe(Long id) {
        return recipeRepository.getById(id);
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public void deleteRecipe(Recipe recipe) {
        recipeRepository.delete(recipe);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient getPatient(Long id) {
        return patientRepository.getById(id);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void deletePatient(Patient patient) {
        patientRepository.delete(patient);
    }
}
