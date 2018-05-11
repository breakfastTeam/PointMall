package com.smartbean.service;


import com.smartbean.domain.Ad;
import com.smartbean.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    public User findOne(Long id);

    public User saveOrUpdate(User brand);

    public List<User> findAll();

    public User signIn(String userName, String password);
}
