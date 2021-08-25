package com.vaadin.vaadin_spring.auxiliary.priority;

import com.vaadin.vaadin_spring.auxiliary.priority.Priority;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PriorityConverter implements AttributeConverter<Priority, String> {
    @Override
    public String convertToDatabaseColumn(Priority priority) {
        return priority.name();
    }

    @Override
    public Priority convertToEntityAttribute(String s) {
        return Priority.valueOf(s);
    }
}
