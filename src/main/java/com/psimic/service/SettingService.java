package com.psimic.service;

import com.psimic.core.GarageDao;
import com.psimic.model.GarageDTO;
import com.psimic.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by psimic on 31.03.15.
 */
@Service
public class SettingService {

    @Autowired private GarageDao garageDao;

    public void setCapacity(GarageDTO garageDTO){
        garageDao.setCapacity(Utils.toGarageFromGarageDTO(garageDTO));
    }

    public Long getFreeSpaces(){
        return garageDao.getCapacity();
    }

}
