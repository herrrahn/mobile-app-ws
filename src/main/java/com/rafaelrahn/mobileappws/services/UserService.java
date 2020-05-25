package com.rafaelrahn.mobileappws.services;

import com.rafaelrahn.mobileappws.models.request.UserDetailsRequestModel;
import com.rafaelrahn.mobileappws.models.response.UserRest;
import org.springframework.stereotype.Service;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
