package com.example.valposystemsdemo.services;

import com.example.valposystemsdemo.mapper.UserMapper;
import com.example.valposystemsdemo.model.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Optional;

//@CrossOrigin('https:\\localhost:4200');
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public ArrayList<UserModel>findUsers(){
        return (ArrayList<UserModel>) userMapper.findAll();
    }
    public boolean deleteUser(Long id){
        try{
            userMapper.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    public boolean putUser(UserModel user){
        try{
            userMapper.putUser(user.getEmail(),user.getUsername(),user.getId());
            return true;
        }catch(Exception err){
            return false;
        }
    }
    public UserModel saveUser(UserModel user){
        UserModel u=user;
        userMapper.save(user.getEmail(),user.getUsername());
        return u;
    }

}
/*public class UserService {
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
}*/
