package org.kito.cookbook.controller.admin;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.kito.cookbook.entity.Recipe;
import org.kito.cookbook.payload.RecipeDetails;
import org.kito.cookbook.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/recipe")
@Tag(name = "ADMIN: Recipe")
public class RecipeAdminController {

    private final RecipeService recipeService;

    public RecipeAdminController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Recipe> create(@RequestBody RecipeDetails details) {
        Recipe recipe = recipeService.create(details);
        return ResponseEntity.status(HttpStatus.CREATED).body(recipe);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Recipe> update(@PathVariable("id") Integer id, @RequestBody RecipeDetails details) {
        Recipe recipe = recipeService.update(id, details);
        return ResponseEntity.ok(recipe);
    }
}
