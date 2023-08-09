package com.devsuperior.dslist.controllers;


import com.devsuperior.dslist.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    //@Autowired
    //private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid UserDTO userDTO) {

        try{
            var authenticationToken = new UsernamePasswordAuthenticationToken(userDTO.login(), userDTO.password());
            var authentication = manager.authenticate(authenticationToken);

            //var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

            //return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

}
