package com.ecommerce.ECommerce.Controller;
import com.ecommerce.ECommerce.DTO.UserDto;
import com.ecommerce.ECommerce.Request.LoginRequest;
import com.ecommerce.ECommerce.Service.UserService;
import com.ecommerce.ECommerce.UserExceptions.PasswordMismatchException;
import com.ecommerce.ECommerce.UserExceptions.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public UserDto registerUser(@RequestBody UserDto userDto) throws UserExistsException {
        return userService.createUser(userDto);
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody LoginRequest loginRequest) throws PasswordMismatchException {
        return userService.validateUser(loginRequest.getEmail(),loginRequest.getPassword());
    }

}
