package com.psimic.core;

import com.psimic.config.SpringMongoConfig;
import com.psimic.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by psimic on 31.03.15.
 */
@Service
public class UsersDao {

    private static final String TEMPLATE = "mongoTemplate";

    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations ops = (MongoOperations) ctx.getBean(TEMPLATE);

    public void saveUser(User user){
        ops.save(user);
    }

    public HashMap<Long, Long> removeUser(String plates) {
        Query query = new Query(Criteria.where("_id").is(plates));
        User user = ops.findOne(query, User.class);
        HashMap<Long, Long> result = user.getLocationInGarage();
        ops.remove(user);
        return result;
    }

    public User getUser(String plates) {
        return ops.findOne(Query.query(Criteria.where("_id").is(plates)), User.class);
    }
}
