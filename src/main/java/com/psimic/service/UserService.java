package com.psimic.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.psimic.core.GarageDao;
import com.psimic.core.UsersDao;
import com.psimic.model.Garage;
import com.psimic.model.User;
import com.psimic.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by psimic on 31.03.15.
 */
@Service
public class UserService {

    @Autowired private UsersDao usersDao;
    @Autowired private GarageDao garageDao;

    public void insertUser(UserDTO userDTO)
    {
        HashMap<Long, Long> location = Maps.newHashMap();
        Garage garage = garageDao.getCapacity();
      //  if()
      //  User user = new User(userDTO.getPlates(), UserType.valueOf(userDTO.getType()), location, true);
      //  usersDao.saveUser(user);
    }

    public List<User> getAllParkedUsers(){ return Lists.newArrayList();}

    public void removeUser(User user){}


}
