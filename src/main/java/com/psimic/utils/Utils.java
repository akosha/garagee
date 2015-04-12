package com.psimic.utils;

import com.google.common.collect.Lists;
import com.psimic.model.Flor;
import com.psimic.model.Garage;
import com.psimic.model.GarageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by psimic on 31.03.15.
 */
@Service
public class Utils {

        public static final Garage toGarageFromGarageDTO(GarageDTO garageDTO) {

                Long florNo = garageDTO.getFlors();
                List<Flor> flors = Lists.newArrayList();
                while (florNo>0){
                    flors.add(new Flor(florNo, garageDTO.getParkingSlotsPerFlor()));
                    florNo--;
                }
                return  new Garage(flors);

    }
}

