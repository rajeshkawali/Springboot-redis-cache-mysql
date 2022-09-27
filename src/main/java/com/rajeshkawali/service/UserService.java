package com.rajeshkawali.service;

import java.util.List;

import com.rajeshkawali.model.User;

/**
 * @author Rajesh_Kawali
 *
 */
public interface UserService {
    public User getUser(long id);
    public List<User> getAllUsers();
    public void delete(long id);
    public User update(User user);
    public User create(User user);
}
