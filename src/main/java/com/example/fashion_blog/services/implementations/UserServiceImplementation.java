package com.example.fashion_blog.services.implementations;


import com.example.fashion_blog.dtos.ApiResponse;
import com.example.fashion_blog.dtos.UserRequestDto;
import com.example.fashion_blog.dtos.UserResponseDto;
import com.example.fashion_blog.entities.User;
import com.example.fashion_blog.enums.Role;
import com.example.fashion_blog.exceptions.CheckDetailsException;
import com.example.fashion_blog.exceptions.InvalidPasswordException;
import com.example.fashion_blog.exceptions.RoleNotAllowedException;
import com.example.fashion_blog.exceptions.UserExistsException;
import com.example.fashion_blog.repositories.UserRepository;
import com.example.fashion_blog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;
    @Override
    public ApiResponse signup(UserRequestDto userRequestDto) {
        if(userRepository.checkIfEmailExists(userRequestDto.getEmail())){
            throw new UserExistsException("User already exists");
        }
        User newUser = User.builder()
                .username(userRequestDto.getUsername())
                .email(userRequestDto.getEmail())
                .role(userRequestDto.getRole())
                .password(userRequestDto.getPassword())
                .build();


        if (userRepository.existsByRole(Role.ADMIN) && newUser.getRole().equals(Role.ADMIN)) {
            throw new RoleNotAllowedException("Role isn't allowed, register as Customer, or Visitor");
        }else
            userRepository.save(newUser);
        UserResponseDto userResponseDto = new UserResponseDto(userRequestDto.getUsername(),userRequestDto.getEmail(),userRequestDto.getRole());
        return new ApiResponse("User signup successful",userResponseDto, HttpStatus.CREATED);
    }

    @Override
    public ApiResponse login(UserRequestDto userRequestDto) {
        User user = userRepository.findByEmailAndPassword(userRequestDto.getEmail(),userRequestDto.getPassword()).orElseThrow(() -> new CheckDetailsException("check email and password"));
        if (user.getPassword().equals(userRequestDto.getPassword()) && user.getEmail().equals(userRequestDto.getEmail())){
            return new ApiResponse("Login successful", HttpStatus.OK);
        }else
            throw new InvalidPasswordException("password not valid");
    }
}
