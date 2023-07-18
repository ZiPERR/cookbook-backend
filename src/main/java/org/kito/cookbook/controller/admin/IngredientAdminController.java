package org.kito.cookbook.controller.admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.kito.cookbook.entity.Ingredient;
import org.kito.cookbook.payload.IngredientDetails;
import org.kito.cookbook.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/ingredient")
@Tag(name = "ADMIN: Ingredient")
public class IngredientAdminController {

    private final IngredientService ingredientService;

    public IngredientAdminController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public ResponseEntity<Ingredient> create(@RequestBody IngredientDetails details) {
        Ingredient ingredient = ingredientService.create(details);
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredient);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Ingredient> update(@PathVariable("id") Integer id, @RequestBody IngredientDetails details) {
        Ingredient ingredient = ingredientService.update(id, details);
        return ResponseEntity.ok(ingredient);
    }
}
