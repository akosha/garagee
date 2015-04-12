package com.psimic.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.psimic.core.GarageDao;
import com.psimic.core.UsersDao;
import com.psimic.model.User;
import com.psimic.model.UserDTO;
import com.psimic.model.UserType;
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
        HashMap<Long, Long> location = Maps.newHashMap();        // long, long === flor, parkingSlot
        if(garageDao.getCapacity()>0){
            location = garageDao.occupieSlot();
            usersDao.saveUser(new User(userDTO.getPlates(), UserType.valueOf(userDTO.getType()), location));
        }
    }

    public List<User> getAllParkedUsers(){ return Lists.newArrayList();}

    public void removeUser(String plates){
        HashMap<Long, Long> location =  usersDao.removeUser(plates);
        garageDao.freeSlot(location);
    }


}
