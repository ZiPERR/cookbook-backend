package org.kito.cookbook.searchCriteria;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FileSearchCriteria {

    private Integer id;
    private String fileName;
    private String path;
}
