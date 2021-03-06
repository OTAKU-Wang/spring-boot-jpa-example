package com.neo.service;

import com.neo.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUserList();

    public User findUserById(String id);

    public void save(User user);

    public void edit(User user);

    public void delete(String id);


}
