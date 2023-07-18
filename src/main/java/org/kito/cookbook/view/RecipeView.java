package org.kito.cookbook.view;

import lombok.Getter;
import org.kito.cookbook.entity.Recipe;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class RecipeView {

    private final Integer id;

    private final String name;

    public RecipeView(Recipe recipe) {
        this.id = recipe.getId();
        this.name = recipe.getName();
    }
}
