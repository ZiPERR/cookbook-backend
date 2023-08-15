package org.kito.cookbook.searchCriteria;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UnitSearchCriteria {

    private Integer id;

    private String name;

    private String shortName;

    private Integer coefficient;
}
