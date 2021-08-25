package com.vaadin.vaadin_spring.repository;

import com.vaadin.vaadin_spring.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
