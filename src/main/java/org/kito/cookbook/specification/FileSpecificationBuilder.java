package org.kito.cookbook.specification;

import org.kito.cookbook.entity.File;
import org.kito.cookbook.searchCriteria.FileSearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class FileSpecificationBuilder implements SpecificationBuilder<File, FileSearchCriteria> {
    @Override
    public Specification<File> build(FileSearchCriteria searchCriteria) {
        Specification<File> specification = null;

        if (searchCriteria.getId() != null) {
            specification = filterById(searchCriteria.getId());
        }

        if (searchCriteria.getFileName() != null) {
            specification = filterByFileName(searchCriteria.getFileName());
        }

        if (searchCriteria.getPath() != null) {
            specification = filterByPath(searchCriteria.getPath());
        }

        return specification;
    }

    private Specification<File> filterById(Integer id) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    private Specification<File> filterByFileName(String fileName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("fileName"), "%" + fileName + "%");
    }

    private Specification<File> filterByPath(String path) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("path"), "%" + path + "%");
    }
}
