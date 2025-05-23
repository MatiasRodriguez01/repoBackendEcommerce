package org.example.ecommercebackend.springsecurity.auth;

import lombok.RequiredArgsConstructor;
import org.example.ecommercebackend.entities.Usuario.Rol;
import org.example.ecommercebackend.entities.Usuario.Usuario;
import org.example.ecommercebackend.repositories.Usuario.UsuarioRepository;
import org.example.ecommercebackend.springsecurity.User.User;
import org.example.ecommercebackend.springsecurity.User.UserRepository;
import org.example.ecommercebackend.springsecurity.jwt.JwtService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getNombre(), request.getContraseña()));
        UserDetails user = usuarioRepository.findByNombre(request.getNombre()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        Usuario user = Usuario.builder()
                .nombre(request.getNombre())
                .contraseña(passwordEncoder.encode(request.getContraseña()))
                .rol(Rol.CLIENTE)
                .email(request.getEmail())
                .dni(request.getDni())
                .build();

        usuarioRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
