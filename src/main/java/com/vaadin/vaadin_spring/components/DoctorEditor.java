package com.vaadin.vaadin_spring.components;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.vaadin_spring.entity.Doctor;
import com.vaadin.vaadin_spring.service.HospitalService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class DoctorEditor extends VerticalLayout implements KeyNotifier {
    private final HospitalService hospitalService;

    private Doctor doctor;

    private TextField name = new TextField("","Name");
    private TextField surname = new TextField("","Surname");
    private TextField patronymic = new TextField("","Patronymic");
    private ComboBox<String> specialization = new ComboBox<>();

    private final String[] defaultSpecializations =
            {"Хирург", "Офтальмолог", "Венеролог", "Терпевт", "Уролог", "Дерматолог", "ЛОР"};

    private Button save = new Button("Save", VaadinIcon.CHECK.create());
    private Button cancel = new Button("Cancel");
    private Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    private HorizontalLayout actions = new HorizontalLayout(save, delete, cancel);

    private Binder<Doctor> binder = new Binder<>(Doctor.class);
    @Setter
    private ChangeHandler changeHandler;

    public interface ChangeHandler {
        void onChange();
    }

    @Autowired
    public DoctorEditor(HospitalService hospitalService) {
        this.hospitalService = hospitalService;

        specialization.setItems(defaultSpecializations);
        specialization.setPlaceholder("Specialization");

        add(surname, name, patronymic, specialization, actions);
        binder.bindInstanceFields(this);

        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());

        // wire action buttons to save, delete and reset
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> setVisible(false));
        setVisible(false);
    }

    public void delete() {
        hospitalService.deleteDoctor(doctor);
        changeHandler.onChange();
    }

    public void save() {
        hospitalService.saveDoctor(doctor);
        changeHandler.onChange();
    }

    public void editDoctor(Doctor newDoctor) {
        if (newDoctor == null) {
            setVisible(false);
            return;
        }
        if (newDoctor.getId() != null) {
            this.doctor = hospitalService.findDoctor(newDoctor.getId()).orElse(newDoctor);
        } else {
            this.doctor = newDoctor;
        }
        //cancel.setVisible(persisted);

        // Bind customer properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        binder.setBean(doctor);

        setVisible(true);

        // Focus first name initially
        name.focus();
    }
}
