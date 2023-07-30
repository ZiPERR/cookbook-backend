package org.kito.cookbook.repository;

import org.kito.cookbook.entity.system.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
