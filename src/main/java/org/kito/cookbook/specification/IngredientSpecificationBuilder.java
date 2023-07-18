package org.kito.cookbook.specification;

import org.kito.cookbook.entity.Ingredient;
import org.kito.cookbook.searchCriteria.IngredientSearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class IngredientSpecificationBuilder implements SpecificationBuilder<Ingredient, IngredientSearchCriteria> {
    @Override
    public Specification<Ingredient> build(IngredientSearchCriteria searchCriteria) {
        Specification<Ingredient> specification = null;

        if (searchCriteria.getId() != null) {
            specification = filterById(searchCriteria.getId());
        }

        if (searchCriteria.getName() != null) {
            specification = filterByName(searchCriteria.getName());
        }

        return specification;
    }

    private Specification<Ingredient> filterById(Integer id) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    private Specification<Ingredient> filterByName(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }
}
