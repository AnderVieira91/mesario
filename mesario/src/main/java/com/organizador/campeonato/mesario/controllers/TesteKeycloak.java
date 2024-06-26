package com.organizador.campeonato.mesario.controllers;


import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/teste")
public class TesteKeycloak {

    /**
     * endpoint sem nenhuma validação de role
     */
    @GetMapping
    public ResponseEntity<Void> isAuthenticated() {
        return ResponseEntity.ok().build();
    }

    /**
     * endpoint onde o usuario tem que ter a role user
     */
    @GetMapping(value = "/has-role")
    @PreAuthorize("hasAnyAuthority('user')")
    public ResponseEntity<Void> isUser(Principal principal) {
        System.out.println(principal.getName());
        return ResponseEntity.ok().build();
    }

    /**
     * endpoint onde o usuario tem que ter a role admin
     */
    @GetMapping(value = "/is-admin")
    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<Void> isAdmin() {
        return ResponseEntity.ok().build();
    }

}
