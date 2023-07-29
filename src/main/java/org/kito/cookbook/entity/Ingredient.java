package org.kito.cookbook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "ingredient")
@Getter
@Setter
@NoArgsConstructor
public class Ingredient {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //TODO: measurement, amount

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "recipe_ingredients",
            joinColumns = {@JoinColumn(name = "ingredient_id")},
            inverseJoinColumns = {@JoinColumn(name = "recipe_id")})
    private Set<Recipe> recipeIngredient;

    @OneToOne
    @JoinTable(name = "ingredient_files",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "file_id"))
    private File ingredientFile;
}
