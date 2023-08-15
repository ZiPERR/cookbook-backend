package org.kito.cookbook.entity.ids;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class RecipeIngredientId implements Serializable {

    private Integer recipeId;

    private Integer ingredientId;
}
