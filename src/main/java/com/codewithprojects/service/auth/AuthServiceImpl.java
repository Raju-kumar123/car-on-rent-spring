package com.codewithprojects.service.auth;

import com.codewithprojects.dtos.SignupRequest;
import com.codewithprojects.dtos.UserDto;
import com.codewithprojects.entities.User;
import com.codewithprojects.enums.UserRole;
import com.codewithprojects.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService{

    private final UserRepository userRepository;
   public void createAdminAccount(){
       
   }
    @Override
    public UserDto createCustomer(SignupRequest signupRequest) {
        User user=new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
       // user.setPassword(signupRequest.getPassword());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setUserRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);
        UserDto userDto=new UserDto();
        userDto.setId(createdUser.getId());

        return userDto;
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {

        return userRepository.findFirstByEmail(email).isPresent();
    }
}
