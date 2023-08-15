package org.kito.cookbook.repository;

import org.kito.cookbook.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Integer>, JpaSpecificationExecutor<Unit> {
    Optional<Unit> findByName(String name);

    Optional<Unit> findByShortName(String shortName);
}
