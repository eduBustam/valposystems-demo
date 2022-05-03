package com.example.valposystemsdemo.repositories;

import com.example.valposystemsdemo.model.UserModel;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract ArrayList<UserModel> findByUsername(String username);
}
