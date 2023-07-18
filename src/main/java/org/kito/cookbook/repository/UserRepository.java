package org.kito.cookbook.repository;

import org.kito.cookbook.entity.system.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AdminUser, Integer> {

    Optional<AdminUser> findByEmail(String email);
}
