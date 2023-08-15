package org.kito.cookbook.specification;

import org.kito.cookbook.entity.RecipeIngredient;
import org.kito.cookbook.searchCriteria.RecipeIngredientSearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class RecipeIngredientSpecificationBuilder
        implements SpecificationBuilder<RecipeIngredient, RecipeIngredientSearchCriteria> {
    @Override
    public Specification<RecipeIngredient> build(RecipeIngredientSearchCriteria searchCriteria) {
        Specification<RecipeIngredient> specification = null;

        if (searchCriteria.getRecipeId() != null) {
            specification = filterByRecipeId(searchCriteria.getRecipeId());
        }

        if (searchCriteria.getIngredientId() != null) {
            specification = filterByIngredientId(searchCriteria.getIngredientId());
        }

        if (searchCriteria.getUnitId() != null) {
            specification = filterByUnitId(searchCriteria.getUnitId());
        }

        if (searchCriteria.getUnitValue() != null) {
            specification = filterByUnitValue(searchCriteria.getUnitValue());
        }


        return specification;
    }

    private Specification<RecipeIngredient> filterByRecipeId(Integer id) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    private Specification<RecipeIngredient> filterByIngredientId(Integer id) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    private Specification<RecipeIngredient> filterByUnitId(Integer id) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    private Specification<RecipeIngredient> filterByUnitValue(Double value) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("value"), value);
    }
}
