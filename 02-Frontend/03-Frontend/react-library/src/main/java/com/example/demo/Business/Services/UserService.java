package com.example.demo.Business.Services;

import com.example.demo.Business.Entities.User;
import com.example.demo.Business.Repos.UserRepository;
import com.example.demo.Business.Repos.UserRepository;
import com.example.demo.Web.DTOs.EntryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   @Autowired
    private final UserRepository userRepository;

    public  UserService (UserRepository userRepo) { this.userRepository = userRepo;  }


    public void addUser(EntryDTO.UserEntryDTO entry ) {
        userRepository.save(new User(entry.name(), entry.income()));
    }




}
