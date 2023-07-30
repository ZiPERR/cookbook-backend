package org.kito.cookbook.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.kito.cookbook.entity.system.Role;
import org.kito.cookbook.entity.system.Users;
import org.kito.cookbook.payload.AuthenticationCredentials;
import org.kito.cookbook.payload.AuthenticationTokenDetails;
import org.kito.cookbook.repository.RoleRepository;
import org.kito.cookbook.repository.UserRepository;
import org.kito.cookbook.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider tokenProvider;

    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       JwtTokenProvider tokenProvider) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    public Users create(@Valid AuthenticationCredentials credentials) {
        // TODO: перед релизом переделать
        Role role = new Role();
        role.setName("GRANT_ADMIN");
        roleRepository.save(role);

        Users user = new Users();
        user.setEmail(credentials.getEmail());
        user.setPassword(passwordEncoder.encode(credentials.getPassword()));
        user.setRole(roleRepository.findById(1).orElseThrow(EntityNotFoundException::new));
        user.setActive(true);
        return userRepository.save(user);
    }

    public AuthenticationTokenDetails authenticate(
            @Valid AuthenticationCredentials credentials) {
        Authentication authenticationData = new UsernamePasswordAuthenticationToken(
                credentials.getEmail(),
                credentials.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(authenticationData);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.generateToken(authentication, credentials.isRememberMe());
        return new AuthenticationTokenDetails(token);
    }
}
