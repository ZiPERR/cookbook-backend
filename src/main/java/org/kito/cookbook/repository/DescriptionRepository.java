package org.kito.cookbook.repository;

import org.kito.cookbook.entity.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Integer>, JpaSpecificationExecutor<Description> {

}
