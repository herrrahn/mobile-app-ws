package com.rafaelrahn.mobileappws.services.implementations;

import com.rafaelrahn.mobileappws.models.request.UserDetailsRequestModel;
import com.rafaelrahn.mobileappws.models.response.UserRest;
import com.rafaelrahn.mobileappws.services.UserService;
import com.rafaelrahn.mobileappws.shared.Utils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users = new HashMap<>();

    private final Utils utils;

    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest userRest = new UserRest();
        userRest.setEmail(userDetails.getEmail());
        userRest.setFirstName(userDetails.getFirstName());
        userRest.setLastName(userDetails.getLastName());
        String userId = utils.generateUserUd();
        userRest.setId(userId);
        users.put(userId, userRest);

        return userRest;
    }
}
