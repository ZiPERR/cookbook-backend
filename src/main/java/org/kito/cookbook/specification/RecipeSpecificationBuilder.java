package org.kito.cookbook.specification;

import org.kito.cookbook.entity.Recipe;
import org.kito.cookbook.searchCriteria.RecipeSearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class RecipeSpecificationBuilder implements SpecificationBuilder<Recipe, RecipeSearchCriteria> {
    @Override
    public Specification<Recipe> build(RecipeSearchCriteria searchCriteria) {
        Specification<Recipe> specification = null;

        if (searchCriteria.getId() != null) {
            specification = filterById(searchCriteria.getId());
        }

        if (searchCriteria.getName() != null) {
            specification = filterByName(searchCriteria.getName());
        }

        return specification;
    }

    private Specification<Recipe> filterById(Integer id) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    private Specification<Recipe> filterByName(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }
}
