package com.psimic.service;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.psimic.core.GarageDao;
import com.psimic.core.UsersDao;
import com.psimic.model.User;
import com.psimic.model.UserDTO;
import com.psimic.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by psimic on 31.03.15.
 */
@Service
public class UserService {

    @Autowired private UsersDao usersDao;
    @Autowired private GarageDao garageDao;

    public String insertUser(UserDTO userDTO)
    {
        HashMap<Long, Long> location = Maps.newHashMap();        // long, long === flor, parkingSlot
        long capacity = garageDao.getCapacity();
        if(Strings.isNullOrEmpty(userDTO.getType()) || Strings.isNullOrEmpty(userDTO.getPlates()) || userDTO.getPlates().length()<3){
            return "Please fill out all fields...";
        }else if(usersDao.getUser(userDTO.getPlates())!=null){
            return "User already in garage";
        } else if(capacity == 0){
            return "Garage full!!!";
        } else if(capacity > 0){
            location = garageDao.occupieSlot();
            usersDao.saveUser(new User(userDTO.getPlates(), UserType.valueOf(userDTO.getType()), location));
            return "Success";
        }
        return "Unknown error, try again...";
    }

    public String removeUser(String plates){
        if(Strings.isNullOrEmpty(plates)){
            return "Please fill plates number...";
        } else if (usersDao.getUser(plates) == null){
            return "Car not in garage or stolen...";
        }
        HashMap<Long, Long> location =  usersDao.removeUser(plates);
        garageDao.freeSlot(location);
        return "Success";
    }


    public User findCarByPlates(String plates) {
        return usersDao.getUser(plates);
    }
}
