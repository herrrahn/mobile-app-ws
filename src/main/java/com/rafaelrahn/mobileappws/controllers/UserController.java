package com.rafaelrahn.mobileappws.controllers;

import com.rafaelrahn.mobileappws.exceptions.UserServiceException;
import com.rafaelrahn.mobileappws.models.request.UpdateUserDetailsRequestModel;
import com.rafaelrahn.mobileappws.models.request.UserDetailsRequestModel;
import com.rafaelrahn.mobileappws.models.response.UserRest;
import com.rafaelrahn.mobileappws.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "users")
public class UserController {

    Map<String, UserRest> users = new HashMap<>();

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{id}", produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<UserRest> getUser(@PathVariable String id) {

        String firstName = null;

        if (true) {
            throw new UserServiceException("Custom exception.");
        }
        int firstNameLength = firstName.length();
        if (users.containsKey(id)) {
        return new ResponseEntity<>(users.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
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
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest userRest = userService.createUser(userDetails);
        return new ResponseEntity<>(userRest, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    }, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public UserRest updateUser(@PathVariable String id, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
        UserRest storeUserDetails = users.get(id);
        storeUserDetails.setFirstName(userDetails.getFirstName());
        storeUserDetails.setLastName(userDetails.getLastName());
        users.put(id, storeUserDetails);

        return storeUserDetails;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        this.users.remove(id);
        return ResponseEntity.noContent().build();
    }
}
