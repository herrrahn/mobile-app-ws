package com.rafaelrahn.mobileappws.ui.controller;

import org.springframework.http.RequestEntity;
import ui.model.request.UserDetailsRequestModel;
import ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @GetMapping(path = "/{id}", produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<UserRest> getUser(@PathVariable int id) {
        UserRest userRest = new UserRest();
        userRest.setFirstName("Rafael");
        userRest.setLastName("Rahn");
        userRest.setEmail("rafael.rahn@live.com");
        return new ResponseEntity<>(userRest, HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit) {
        return String.format("get users was called for page %d limit %d", page, limit);
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    }, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserRest userRest = new UserRest();
        userRest.setEmail(userDetails.getEmail());
        userRest.setFirstName(userDetails.getFirstName());
        userRest.setLastName(userDetails.getLastName());
        return new ResponseEntity<>(userRest, HttpStatus.I_AM_A_TEAPOT);
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
