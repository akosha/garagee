package com.psimic.model;

/**
 * Created by psimic on 31.03.15.
 */
public class UserDTO {

    private String plates;
    private String type;

    public UserDTO() {
    }

    public UserDTO(String plates, String type) {
        this.plates = plates;
        this.type = type;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "plates='" + plates + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
