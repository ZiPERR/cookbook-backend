package org.kito.cookbook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "file")
@Getter
@Setter
@NoArgsConstructor
public class File {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "filename", nullable = false)
    private String fileName;

    @Column(name = "path", nullable = false)
    private String path;

    @OneToOne(mappedBy = "file")
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "recipe_files",
            joinColumns = {@JoinColumn(name = "file_id")},
            inverseJoinColumns = {@JoinColumn(name = "recipe_id")})
    private Recipe recipe;
}
