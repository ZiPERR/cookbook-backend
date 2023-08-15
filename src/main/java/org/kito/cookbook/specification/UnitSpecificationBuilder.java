package org.kito.cookbook.specification;

import org.kito.cookbook.entity.Unit;
import org.kito.cookbook.searchCriteria.UnitSearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class UnitSpecificationBuilder implements SpecificationBuilder<Unit, UnitSearchCriteria> {
    @Override
    public Specification<Unit> build(UnitSearchCriteria searchCriteria) {
        Specification<Unit> specification = null;

        if (searchCriteria.getId() != null) {
            specification = filterById(searchCriteria.getId());
        }

        if (searchCriteria.getName() != null) {
            specification = filterByName(searchCriteria.getName());
        }

        if (searchCriteria.getShortName() != null) {
            specification = filterByShortName(searchCriteria.getShortName());
        }

        if (searchCriteria.getCoefficient() != null) {
            specification = filterByCoefficient(searchCriteria.getCoefficient());
        }

        return specification;
    }

    private Specification<Unit> filterById(Integer id) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    private Specification<Unit> filterByName(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    private Specification<Unit> filterByShortName(String shortName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("shortName"), "%" + shortName + "%");
    }

    private Specification<Unit> filterByCoefficient(Integer coefficient) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("coefficient"), coefficient);
    }
}
