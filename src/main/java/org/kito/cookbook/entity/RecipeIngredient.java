package org.kito.cookbook.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kito.cookbook.entity.ids.RecipeIngredientId;

@Entity
@Table(name = "recipe_ingredients")
@Getter
@Setter
@NoArgsConstructor
@IdClass(RecipeIngredientId.class)
public class RecipeIngredient {

    @Id
    @Column(name = "recipe_id", nullable = false)
    private Integer recipeId;

    @Id
    @Column(name = "ingredient_id", nullable = false)
    private Integer ingredientId;

    @Column(name = "unit_value", nullable = false)
    private Double unitValue;

    @OneToOne
    private Unit unit;
}
