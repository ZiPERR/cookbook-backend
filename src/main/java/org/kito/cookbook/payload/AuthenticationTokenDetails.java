package org.kito.cookbook.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthenticationTokenDetails {

    private final String token;

    private final String tokenType = "Bearer";
}
