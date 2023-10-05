package com.food.app.service;

import com.food.app.domain.User;
import com.food.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> displayUsers(){
        return userRepository.findAll();
    }

    public void saveAllUsers(List<User> users){
        userRepository.saveAll(users);
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public User findById(Integer id){
        return userRepository.findById(id).get();
    }

    public void updateUserById(Integer id,User user){

        User existingUser = userRepository.findById(id)
                        .orElseThrow(()-> new EntityNotFoundException("User not find "+id));

        // Update the fields of the existing employee
        existingUser.setFirstName(user.getFirstName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());

        userRepository.save(existingUser);
    }

    public void deleteByUserId(Integer id){
        userRepository.deleteById(id);
    }
}
