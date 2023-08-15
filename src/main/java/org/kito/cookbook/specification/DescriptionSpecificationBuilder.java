package org.kito.cookbook.specification;

import org.kito.cookbook.entity.Description;
import org.kito.cookbook.searchCriteria.DescriptionSearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class DescriptionSpecificationBuilder implements SpecificationBuilder<Description, DescriptionSearchCriteria> {
    @Override
    public Specification<Description> build(DescriptionSearchCriteria searchCriteria) {
        Specification<Description> specification = null;

        if (searchCriteria.getId() != null) {
            specification = filterById(searchCriteria.getId());
        }

        if (searchCriteria.getDescription() != null) {
            specification = filterByDescription(searchCriteria.getDescription());
        }
        return specification;
    }

    private Specification<Description> filterById(Integer id) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    private Specification<Description> filterByDescription(String description) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get(description), "%" + description + "%");
    }
}
