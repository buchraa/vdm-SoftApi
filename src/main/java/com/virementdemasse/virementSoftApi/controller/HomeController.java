package com.virementdemasse.virementSoftApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
public class HomeController {
    @GetMapping("/home")
    public ResponseEntity<String> Message() {
        return new ResponseEntity<>("Accueil", HttpStatus.OK);
    }
}
