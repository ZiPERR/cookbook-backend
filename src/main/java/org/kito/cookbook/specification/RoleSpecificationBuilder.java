package org.kito.cookbook.specification;

import org.kito.cookbook.entity.system.Role;
import org.kito.cookbook.searchCriteria.RoleSearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class RoleSpecificationBuilder implements SpecificationBuilder<Role, RoleSearchCriteria> {
    @Override
    public Specification<Role> build(RoleSearchCriteria searchCriteria) {
        Specification<Role> specification = null;

        if (searchCriteria.getId() != null) {
            specification = filterById(searchCriteria.getId());
        }

        if (searchCriteria.getName() != null) {
            specification = filterByName(searchCriteria.getName());
        }

        return specification;
    }

    private Specification<Role> filterById(Integer id) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    private Specification<Role> filterByName(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }
}
