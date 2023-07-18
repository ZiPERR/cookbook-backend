package org.kito.cookbook.payload;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kito.cookbook.validator.OnCreate;

@Data
@NoArgsConstructor
public class IngredientDetails {

    @NotNull(message = "{name.not_null}", groups = OnCreate.class)
    private String name;
}
