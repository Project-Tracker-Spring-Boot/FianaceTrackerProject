package com.example.demo.Business.Services;

import com.example.demo.Business.Entities.User;
import com.example.demo.Business.Repos.UserRepository;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserService {

   @Autowired
    private final UserRepository userRepository;

    public  UserService (UserRepository userRepo) { this.userRepository = userRepo;  }



    @OneToMany
    public Optional<User> getUser(Long id ) {

        Optional<User> probe = userRepository.findById(id);

        return probe;
    }



    public String  changePassword (String value , User user ) {

        user.password = value;

        return "Password has been changed";


    }

    public String getEmail (User user) {
        return  user.email;


    }




}
