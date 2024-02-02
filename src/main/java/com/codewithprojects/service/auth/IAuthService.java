package com.codewithprojects.service.auth;

import com.codewithprojects.dtos.SignupRequest;
import com.codewithprojects.dtos.UserDto;

public interface IAuthService {
    UserDto createCustomer(SignupRequest signupRequest);
    boolean hasCustomerWithEmail(String email);
}
