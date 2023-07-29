package org.kito.cookbook.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "description")
@Getter
@Setter
@NoArgsConstructor
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Type(JsonType.class)
    @Column(name = "description", nullable = false, columnDefinition = "jsonb")
    private String description;

    @OneToOne(mappedBy = "description")
    private Recipe recipeDescription;
}
