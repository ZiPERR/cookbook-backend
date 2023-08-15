package org.kito.cookbook.repository;

import org.kito.cookbook.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Integer>, JpaSpecificationExecutor<File> {
}
