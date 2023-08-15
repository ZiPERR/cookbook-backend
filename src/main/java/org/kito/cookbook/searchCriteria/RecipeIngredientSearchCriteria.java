package org.kito.cookbook.searchCriteria;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RecipeIngredientSearchCriteria {

    private Integer recipeId;

    private Integer ingredientId;

    private Integer unitId;

    private Double unitValue;
}
