package org.kito.cookbook.view;

import lombok.Getter;
import org.kito.cookbook.entity.Ingredient;

@Getter
public class IngredientView {

    private final Integer id;

    private final String name;

    public IngredientView(Ingredient ingredient) {
        this.id = ingredient.getId();
        this.name = ingredient.getName();
    }
}
