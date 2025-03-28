package com.arthur.api.controller;

import com.arthur.api.dto.LoginRequestDto;
import com.arthur.api.security.AuthorizationService;
import com.arthur.api.security.dto.AuthorizationDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UsuarioController {

    private final AuthenticationManager authenticationManager;

    private final AuthorizationService authorizationService;

    @PostMapping("/login")
    public ResponseEntity<AuthorizationDTO> auth(@RequestBody @Valid LoginRequestDto credentials){
        var usernamePassword = new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getSenha());
        Authentication authentication = this.authenticationManager.authenticate(usernamePassword);
        AuthorizationDTO responseBody = authorizationService.generateAuthorization(authentication);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/testToken")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Você está autenticado!", HttpStatus.OK);
    }

}

