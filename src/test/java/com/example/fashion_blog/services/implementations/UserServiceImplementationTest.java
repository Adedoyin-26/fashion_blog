package com.example.fashion_blog.services.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.fashion_blog.dtos.ApiResponse;
import com.example.fashion_blog.dtos.UserRequestDto;
import com.example.fashion_blog.dtos.UserResponseDto;
import com.example.fashion_blog.entities.User;
import com.example.fashion_blog.enums.Role;
import com.example.fashion_blog.exceptions.CheckDetailsException;
import com.example.fashion_blog.exceptions.RoleNotAllowedException;
import com.example.fashion_blog.exceptions.UserExistsException;
import com.example.fashion_blog.repositories.UserRepository;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@Configuration
//@ContextConfiguration(classes = {UserServiceImplementation.class})
//@ExtendWith(SpringExtension.class)
class UserServiceImplementationTest {
//    @MockBean
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserServiceImplementation userServiceImplementation;
//
//    /**
//     * Method under test: {@link UserServiceImplementation#signup(UserRequestDto)}
//     */
//    @Test
//    void testSignup() {
//        when(userRepository.checkIfEmailExists(Mockito.<String>any())).thenReturn(true);
//        assertThrows(UserExistsException.class, () -> userServiceImplementation
//                .signup(new UserRequestDto("walex", "ibrah@gmail.com", "iloveyou", Role.ADMIN)));
//        verify(userRepository).checkIfEmailExists(Mockito.<String>any());
//    }
//
//    /**
//     * Method under test: {@link UserServiceImplementation#signup(UserRequestDto)}
//     */
//    @Test
//    void testSignup2() {
//        when(userRepository.checkIfEmailExists(Mockito.<String>any())).thenReturn(false);
//        when(userRepository.existsByRole(Mockito.<Role>any())).thenReturn(true);
//        assertThrows(RoleNotAllowedException.class, () -> userServiceImplementation
//                .signup(new UserRequestDto("walex", "ibrah@gmail.com", "iloveyou", Role.ADMIN)));
//        verify(userRepository).checkIfEmailExists(Mockito.<String>any());
//        verify(userRepository).existsByRole(Mockito.<Role>any());
//    }
//
//    /**
//     * Method under test: {@link UserServiceImplementation#signup(UserRequestDto)}
//     */
//    @Test
//    void testSignup3() {
//        when(userRepository.checkIfEmailExists(Mockito.<String>any()))
//                .thenThrow(new CheckDetailsException("User signup successful"));
//        assertThrows(CheckDetailsException.class, () -> userServiceImplementation
//                .signup(new UserRequestDto("walex", "ibrah@gmail.com", "iloveyou", Role.ADMIN)));
//        verify(userRepository).checkIfEmailExists(Mockito.<String>any());
//    }
//
//    /**
//     * Method under test: {@link UserServiceImplementation#signup(UserRequestDto)}
//     */
//    @Test
//    void testSignup4() {
//        User user = new User();
//        user.setCreatedAt(LocalDate.of(2023, 10, 1).atStartOfDay());
//        user.setEmail("ibrah@gmail.com");
//        user.setId(1L);
//        user.setPassword("iloveyou");
//        user.setRole(Role.ADMIN);
//        user.setUpdatedAt(LocalDate.of(2023, 10, 1).atStartOfDay());
//        user.setUsername("walex");
//        when(userRepository.checkIfEmailExists(Mockito.<String>any())).thenReturn(false);
//        when(userRepository.existsByRole(Mockito.<Role>any())).thenReturn(false);
//        when(userRepository.save(Mockito.<User>any())).thenReturn(user);
//        ApiResponse actualSignupResult = userServiceImplementation
//                .signup(new UserRequestDto("walex", "ibrah@gmail.com", "iloveyou", Role.ADMIN));
//        verify(userRepository).checkIfEmailExists(Mockito.<String>any());
//        verify(userRepository).existsByRole(Mockito.<Role>any());
//        verify(userRepository).save(Mockito.<User>any());
//        Object data = actualSignupResult.getData();
//        assertTrue(data instanceof UserResponseDto);
//        assertEquals("User signup successful", actualSignupResult.getMessage());
//        assertEquals("ibrah@gmail.com", ((UserResponseDto) data).email());
//        assertEquals("walex", ((UserResponseDto) data).username());
//        assertEquals(Role.ADMIN, ((UserResponseDto) data).role());
//        assertEquals(HttpStatus.CREATED, actualSignupResult.getStatus());
//    }
}
