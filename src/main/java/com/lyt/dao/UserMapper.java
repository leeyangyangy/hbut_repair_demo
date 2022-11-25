package com.lyt.dao;

import com.lyt.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User login(User user);


}
