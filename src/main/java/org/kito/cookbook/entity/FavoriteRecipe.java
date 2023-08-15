package org.kito.cookbook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "favorite_recipes")
@Getter
@Setter
@NoArgsConstructor
public class FavoriteRecipe {

    @Id
    @Column(name = "recipe_id", nullable = false)
    private Integer recipeId;

    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;
}
