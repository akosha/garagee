package com.psimic.model;

import java.util.List;

/**
 * Created by psimic on 31.03.15.
 */
public class Flor {

    private Long florId;
    private List<ParkingSlot> parkingSlots;

    public Flor(Long florId, List<ParkingSlot> parkingSlots) {
        this.florId = florId;
        this.parkingSlots = parkingSlots;
    }

    public Long getFlorId() {
        return florId;
    }

    public void setFlorId(Long florId) {
        this.florId = florId;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    @Override
    public String toString() {
        return "Flor{" +
                "florId=" + florId +
                ", parkingSlots=" + parkingSlots +
                '}';
    }
}
