package com.psimic.core;

import com.psimic.config.SpringMongoConfig;
import com.psimic.model.Garage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * Created by psimic on 31.03.15.
 */
@Service
public class GarageDao {

    private static final String TEMPLATE = "mongoTemplate";

    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations ops = (MongoOperations) ctx.getBean(TEMPLATE);

    public void setCapacity(Garage garage){
        ops.save(garage);
    }

    public Garage getCapacity(){
        Query query = new Query(Criteria.where("_id").exists(true));
        return ops.findOne(query, Garage.class);
    }

}
