package com.psimic.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by psimic on 12.04.15.
 */
@Document(collection = "parkingSlot")
public class ParkingSlot {

    private long parkingId;
    private long florId;
    private boolean occupied;

    public ParkingSlot() {
    }

    public ParkingSlot(long parkingId, boolean occupied, long florId) {
        this.parkingId = parkingId;
        this.occupied = occupied;
        this.florId = florId;
    }

    public long getParkingId() {
        return parkingId;
    }

    public void setParkingId(long parkingId) {
        this.parkingId = parkingId;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public long getFlorId() {
        return florId;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "parkingId=" + parkingId +
                ", occupied=" + occupied +
                '}';
    }
}
