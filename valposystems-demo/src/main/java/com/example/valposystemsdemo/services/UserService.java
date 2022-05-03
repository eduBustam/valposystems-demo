package com.example.valposystemsdemo.services;

import com.example.valposystemsdemo.model.UserModel;
import com.example.valposystemsdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Optional;

//@CrossOrigin('https:\\localhost:4200');
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> findUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }
    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }
    public Optional<UserModel> findUserById(Long id){
        return userRepository.findById(id);
    }
    public ArrayList<UserModel>findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
