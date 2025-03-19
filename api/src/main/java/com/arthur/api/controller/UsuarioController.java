package com.arthur.api.controller;

import com.arthur.api.domain.Usuario;
import com.arthur.api.dto.LoginRequestDto;
import com.arthur.api.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostConstruct
    private void init(){
        Usuario usuario = usuarioRepository.findByEmail("admin@arthur.com");
        if(usuario == null){
            Usuario admin = new Usuario();
            admin.setEmail("admin@arthur.com");
            admin.setSenha("admin123");
            admin.setNome("Arthur");
            usuarioRepository.save(admin);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> getResposta(@RequestBody LoginRequestDto requestDto){
       var usuario = usuarioRepository.findByEmailAndSenha(requestDto.getEmail(), requestDto.getSenha());

       if(usuario == null){
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha incorretos!");
       } else{
           return new ResponseEntity<>("OK", HttpStatus.OK);
       }
    }
}
