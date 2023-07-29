package org.kito.cookbook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipe_files")
@Getter
@Setter
@NoArgsConstructor
public class RecipeFile {

    @Id
    @Column(name = "file_id", nullable = false)
    private Integer fileId;

    @Id
    @Column(name = "recipe_id", nullable = false)
    private Integer recipeId;

}
