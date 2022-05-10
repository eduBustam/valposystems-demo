package com.example.valposystemsdemo.controler;

import com.example.valposystemsdemo.model.UserModel;
import com.example.valposystemsdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ArrayList<UserModel> findUsers(){
        return userService.findUsers();
    }
    @DeleteMapping(path= "/{id}")
    public String deleteUserById (@PathVariable("id")Long id){
        boolean ok=this.userService.deleteUser(id);
        if(ok){
            return "Se eliminó el user con id "+ id;
        }else{
            return "No se pudo eliminar el user con id" + id;
        }
    }
    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }
    @PutMapping(path="/{id}")
    public String updateUser(@RequestBody UserModel user){
        boolean ok=this.userService.putUser(user);
        if(ok){
            return "Se edito el user con id "+ user.getId();
        }else{
            return "No se pudo editar el user con id" + user.getId();
        }
    }


}
/*public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> findUsers(){
        return userService.findUsers();
    }
    @GetMapping(path= "/{id}")
    public Optional<UserModel> findUserById(@PathVariable ("id") Long id){
        return this.userService.findUserById(id);
    }
    @GetMapping("/search")
    public ArrayList<UserModel>findUserByUsername(@RequestParam("username") String username){
        return this.userService.findByUsername(username);
    }
    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @DeleteMapping(path= "/{id}")
    public String deleteUserById (@PathVariable("id")Long id){
        boolean ok=this.userService.deleteUser(id);
        if(ok){
            return "Se eliminó el user con id "+ id;
        }else{
            return "No se pudo eliminar el user con id" + id;
        }
    }

}*/
