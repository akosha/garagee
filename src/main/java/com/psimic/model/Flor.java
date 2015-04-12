package com.psimic.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by psimic on 31.03.15.
 */
@Document(collection = "flor")
public class Flor {

    private Long florId;
    private Long florCapacity;

    public Flor(Long florId, Long florCapacity) {
        this.florId = florId;
        this.florCapacity = florCapacity;
    }

    public Long getFlorId() {
        return florId;
    }

    public void setFlorId(Long florId) {
        this.florId = florId;
    }

    public Long getFlorCapacity() {
        return florCapacity;
    }

    public void setFlorCapacity(Long florCapacity) {
        this.florCapacity = florCapacity;
    }

    @Override
    public String toString() {
        return "Flor{" +
                "florId=" + florId +
                ", florCapacity=" + florCapacity +
                '}';
    }
}
