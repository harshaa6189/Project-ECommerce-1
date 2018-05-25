package com.ecommerce.ECommerce.Service;

import com.ecommerce.ECommerce.DTO.UserDto;
import com.ecommerce.ECommerce.Model.UserModel;
import com.ecommerce.ECommerce.Repository.UserRepository;
import com.ecommerce.ECommerce.UserExceptions.PasswordMismatchException;
import com.ecommerce.ECommerce.UserExceptions.UserExistsException;
import com.ecommerce.ECommerce.UserSecurity.HashPassword;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) throws UserExistsException {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new UserExistsException("User Already Existing");
        }

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        userRepository.save(userModel);
        return userDto;
    }

    @Override
    public String validateUser(String email, String password) throws PasswordMismatchException {
        UserModel userModel = userRepository.findByEmail(email);
        password = HashPassword.MD5(password);
        if(!password.equals(userModel.getPassword())){
            throw new PasswordMismatchException("passwords do not match, please try again");
        }
        return "successfully logged in";
    }

}
