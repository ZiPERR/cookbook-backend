package org.kito.cookbook.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.kito.cookbook.entity.Ingredient;
import org.kito.cookbook.searchCriteria.IngredientSearchCriteria;
import org.kito.cookbook.service.IngredientService;
import org.kito.cookbook.specification.IngredientSpecificationBuilder;
import org.kito.cookbook.view.IngredientView;
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
@RequestMapping("/api/v1/ingredient")
@Tag(name = "USER: Ingredient")
public class IngredientController {

    private final IngredientService ingredientService;

    private final IngredientSpecificationBuilder specificationBuilder;

    public IngredientController(IngredientService ingredientService,
                                IngredientSpecificationBuilder specificationBuilder) {
        this.ingredientService = ingredientService;
        this.specificationBuilder = specificationBuilder;
    }

    @GetMapping
    public ResponseEntity<List<IngredientView>> findAll(@Valid IngredientSearchCriteria searchCriteria, Pageable pageable) {
        Specification<Ingredient> ingredientSpecification = specificationBuilder.build(searchCriteria);
        Page<Ingredient> ingredients = ingredientService.findAll(ingredientSpecification, pageable);
        List<IngredientView> ingredientViews = ingredients.stream().map(IngredientView::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(ingredientViews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientView> findById(@PathVariable("id") Integer id) {
        Ingredient ingredient = ingredientService.findById(id);
        return ResponseEntity.ok(new IngredientView(ingredient));
    }
}
