package com.vaadin.vaadin_spring.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.vaadin_spring.components.DoctorEditor;
import com.vaadin.vaadin_spring.entity.Doctor;
import com.vaadin.vaadin_spring.entity.Patient;
import com.vaadin.vaadin_spring.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@Route("")
public class MainView extends VerticalLayout {

    private final HospitalService service;
    private final Grid<Doctor> doctorGrid;
    private final Grid<Patient> patientGrid;
    private final Button addNewComponent = new Button("Add", VaadinIcon.PLUS.create());
    private final DoctorEditor doctorEditor;
    private final HorizontalLayout toolbar = new HorizontalLayout(addNewComponent);

    private final Tab doctors = new Tab("Doctors");
    private final Tab patients = new Tab("Patients");
    private final Tab recipes = new Tab("Recipes");
    private final Tabs tabs = new Tabs(doctors, patients, recipes);
    private Map<Tab, Grid> gridMap = new HashMap<>();

    @Autowired
    public MainView(HospitalService service, DoctorEditor doctorEditor) {
        this.service = service;
        this.doctorEditor = doctorEditor;

        this.doctorGrid = new Grid<>(Doctor.class);

        this.patientGrid = new Grid<>(Patient.class);
        patientGrid.setVisible(false);

        gridMap.put(doctors, doctorGrid);
        gridMap.put(patients, patientGrid);

        doctorGrid.setHeight("300px");
        // Connect selected Customer to editor or hide if none is selected
        doctorGrid.asSingleSelect().addValueChangeListener(e -> doctorEditor.editDoctor(e.getValue()));

        // Instantiate and edit new Customer the new button is clicked
        addNewComponent.addClickListener(e ->
                doctorEditor.editDoctor(new Doctor()));

        // Listen changes made by the editor, refresh data from backend
        doctorEditor.setChangeHandler(() -> {
            doctorEditor.setVisible(false);
            doctorGrid.setItems(service.getAllDoctors());
            //listCustomers(filter.getValue());
        });

        // Initialize listing
        //listCustomers(null);

        listDoctors();
    }

    private void listDoctors() {
        doctorGrid.setItems(service.getAllDoctors());
    }

}