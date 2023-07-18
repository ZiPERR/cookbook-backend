package org.kito.cookbook.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.kito.cookbook.entity.Ingredient;
import org.kito.cookbook.payload.IngredientDetails;
import org.kito.cookbook.repository.IngredientRepository;
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
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Page<Ingredient> findAll(Specification<Ingredient> specification, Pageable pageable) {
        return ingredientRepository.findAll(specification, pageable);
    }

    public Ingredient findById(Integer id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ingredient not found"));
    }

    @Validated(OnCreate.class)
    public Ingredient create(@Valid IngredientDetails details) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(details.getName());

        return ingredientRepository.save(ingredient);
    }

    @Validated(OnUpdate.class)
    public Ingredient update(Integer id, @Valid IngredientDetails details) {
        Ingredient ingredient = findById(id);

        Optional.ofNullable(details.getName()).ifPresent(ingredient::setName);

        return ingredientRepository.save(ingredient);
    }
}
