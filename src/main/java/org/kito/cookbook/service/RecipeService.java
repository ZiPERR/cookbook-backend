package org.kito.cookbook.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.kito.cookbook.entity.Recipe;
import org.kito.cookbook.payload.RecipeDetails;
import org.kito.cookbook.repository.RecipeRepository;
import org.kito.cookbook.validator.OnCreate;
import org.kito.cookbook.validator.OnUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Page<Recipe> findAll(Specification<Recipe> specification, Pageable pageable) {
        return recipeRepository.findAll(specification, pageable);
    }

    public Recipe findById(Integer id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe not found"));
    }

    @Validated(OnCreate.class)
    public Recipe create(@Valid RecipeDetails details) {
        Recipe recipe = new Recipe();
        recipe.setName(details.getName());

        return recipeRepository.save(recipe);
    }

    @Validated(OnUpdate.class)
    public Recipe update(Integer id, @Valid RecipeDetails details) {
        Recipe recipe = findById(id);

        Optional.ofNullable(details.getName()).ifPresent(recipe::setName);

        return recipeRepository.save(recipe);
    }
}
