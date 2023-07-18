package org.kito.cookbook.controller.admin;

import org.kito.cookbook.payload.AuthenticationCredentials;
import org.kito.cookbook.payload.AuthenticationTokenDetails;
import org.kito.cookbook.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationTokenDetails> authenticate(
            @RequestBody AuthenticationCredentials credentials
    ) {
        return ResponseEntity.ok(this.userService.authenticate(credentials));
    }
}
