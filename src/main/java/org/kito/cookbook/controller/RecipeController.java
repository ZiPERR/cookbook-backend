package org.kito.cookbook.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.kito.cookbook.entity.Recipe;
import org.kito.cookbook.searchCriteria.RecipeSearchCriteria;
import org.kito.cookbook.service.RecipeService;
import org.kito.cookbook.specification.RecipeSpecificationBuilder;
import org.kito.cookbook.view.RecipeView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recipe")
@Tag(name = "USER: Recipe")
public class RecipeController {

    private final RecipeService recipeService;

    private final RecipeSpecificationBuilder specificationBuilder;

    public RecipeController(RecipeService recipeService,
                            RecipeSpecificationBuilder specificationBuilder) {
        this.recipeService = recipeService;
        this.specificationBuilder = specificationBuilder;
    }

    @GetMapping
    public ResponseEntity<List<RecipeView>> findAll(@Valid RecipeSearchCriteria searchCriteria, Pageable pageable) {
        Specification<Recipe> ingredientSpecification = specificationBuilder.build(searchCriteria);
        Page<Recipe> recipes = recipeService.findAll(ingredientSpecification, pageable);
        List<RecipeView> recipeViews = recipes.stream().map(RecipeView::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(recipeViews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeView> findById(@PathVariable("id") Integer id) {
        Recipe recipe = recipeService.findById(id);
        return ResponseEntity.ok(new RecipeView(recipe));
    }
}
