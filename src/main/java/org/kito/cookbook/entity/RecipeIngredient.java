package org.kito.cookbook.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipe_ingredients")
@Getter
@Setter
@NoArgsConstructor
public class RecipeIngredient {

    @Id
    @Column(name = "recipe_id", nullable = false)
    private Integer recipeId;

    @Id
    @Column(name = "ingredient_id", nullable = false)
    private Integer ingredientId;

    @Column(name = "ingredient_amount", nullable = false)
    private Double amount;

    @OneToOne
    private Unit unit;
}
