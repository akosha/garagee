package com.psimic.model;

/**
 * Created by psimic on 31.03.15.
 */
public class GarageDTO {

    private Long flors;
    private Long parkingSlotsPerFlor;

    public GarageDTO() {
    }

    public GarageDTO(Long florsNo, Long spacesPerFlorNo) {
        this.flors = florsNo;
        this.parkingSlotsPerFlor = spacesPerFlorNo;
    }

    public Long getFlors() {
        return flors;
    }

    public void setFlors(Long flors) {
        this.flors = flors;
    }

    public Long getParkingSlotsPerFlor() {
        return parkingSlotsPerFlor;
    }

    public void setParkingSlotsPerFlor(Long parkingSlotsPerFlor) {
        this.parkingSlotsPerFlor = parkingSlotsPerFlor;
    }

    @Override
    public String toString() {
        return "GarageDTO{" +
                "flors=" + flors +
                ", parkingSlotsPerFlor=" + parkingSlotsPerFlor +
                '}';
    }

}
