package com.psimic.utils;

import com.google.common.collect.Lists;
import com.psimic.model.Flor;
import com.psimic.model.Garage;
import com.psimic.model.GarageDTO;
import com.psimic.model.ParkingSlot;
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
            Long pakingSlotPerFlor = garageDTO.getParkingSlotsPerFlor();
            List<ParkingSlot> slots = Lists.newArrayList();
            while(pakingSlotPerFlor>0){
                slots.add(new ParkingSlot(pakingSlotPerFlor, false, florNo));
                pakingSlotPerFlor--;
            }
            flors.add(new Flor(florNo, slots));
            florNo--;
        }
        return  new Garage(flors);

    }
}

