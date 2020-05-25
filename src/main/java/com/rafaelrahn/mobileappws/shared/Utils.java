package com.rafaelrahn.mobileappws.shared;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Utils {
    public String generateUserUd() {
        return UUID.randomUUID().toString();
    }
}
