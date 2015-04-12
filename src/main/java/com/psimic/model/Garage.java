package com.psimic.model;

import java.util.List;

/**
 * Created by psimic on 31.03.15.
 */
public class Garage {

    private List<Flor> flors;

    public Garage() {
    }

    public Garage(List<Flor> flors) {
        this.flors = flors;
    }

    public List<Flor> getFlors() {
        return flors;
    }

    public void setFlors(List<Flor> flors) {
        this.flors = flors;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "flors=" + flors +
                '}';
    }
}
