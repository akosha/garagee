package com.psimic.core;

import com.google.common.collect.Maps;
import com.psimic.config.SpringMongoConfig;
import com.psimic.model.Flor;
import com.psimic.model.Garage;
import com.psimic.model.ParkingSlot;
import com.psimic.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by psimic on 31.03.15.
 */
@Service
public class GarageDao {

    private static final String TEMPLATE = "mongoTemplate";

    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations ops = (MongoOperations) ctx.getBean(TEMPLATE);

    public void setCapacity(Garage garage){
        ops.dropCollection(User.class);       //remove cars before works...
        ops.dropCollection(ParkingSlot.class);  //remove lots before works...
        for (Flor flor : garage.getFlors()) {
            for (ParkingSlot slot: flor.getParkingSlots()) {
                ops.save(slot);
            }
        }
    }

    public long getCapacity(){
        Query query = new Query(Criteria.where("occupied").is(false));
        return ops.count(query, ParkingSlot.class);
    }

    public HashMap<Long, Long> occupieSlot() {
        Query query = new Query(Criteria.where("occupied").is(false));
        ParkingSlot slot = ops.findOne(query, ParkingSlot.class);
        Query updateQuery = new Query(Criteria.where("parkingId").is(slot.getParkingId()).and("florId").is(slot.getFlorId()));
        ops.upsert(updateQuery, Update.update("occupied", true), ParkingSlot.class);
        HashMap<Long, Long> result =  Maps.newHashMap();
        result.put(slot.getFlorId(), slot.getParkingId());
        return result;
    }

    public void freeSlot(HashMap<Long, Long> location) {
        Long florId = location.keySet().iterator().next();
        Long parkingSlot = location.get(florId);
        Query updateQuery = new Query(Criteria.where("parkingId").is(parkingSlot).and("florId").is(florId));
        ops.upsert(updateQuery, Update.update("occupied", false), ParkingSlot.class);
    }
}
