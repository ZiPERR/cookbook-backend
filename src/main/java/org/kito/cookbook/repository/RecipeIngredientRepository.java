package org.kito.cookbook.repository;

import org.kito.cookbook.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Integer>,
        JpaSpecificationExecutor<RecipeIngredient> {

}
